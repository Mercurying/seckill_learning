package com.mercury.service.impl;

import com.mercury.dao.OrderDOMapper;
import com.mercury.dao.SequenceDOMapper;
import com.mercury.dataobject.OrderDO;
import com.mercury.dataobject.SequenceDO;
import com.mercury.error.BusinessException;
import com.mercury.error.EnumBusinessError;
import com.mercury.service.ItemService;
import com.mercury.service.OrderService;
import com.mercury.service.UserService;
import com.mercury.service.model.ItemModel;
import com.mercury.service.model.OrderModel;
import com.mercury.service.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    public static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDOMapper orderDOMapper;
    @Autowired
    private SequenceDOMapper sequenceDOMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

    // 保证创建订单与减库存是在同一个事务中进行的
    @Transactional
    @Override
    public OrderModel createOrder(Integer userId, Integer itemId, Integer promoId, Integer amount) throws BusinessException {
        // 规则：
        // 参数校验 用户是否合法 商品是否存在 购买数量是否正常 秒杀活动商品信息校验
        // 库存修改：1.落单减库存【项目使用方式】 2.支付减库存
        // 入库操作
        // 返回前端订单信息
        UserModel userModel = userService.getUserById(userId);
        if (userModel == null) {
            throw new BusinessException(EnumBusinessError.USER_NOT_EXIST);
        }
        ItemModel itemModel = itemService.getItemById(itemId);
        if (itemModel == null) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR, "不存在该商品信息");
        }
        if (amount <= 0 || amount > 99) {
            throw new BusinessException(EnumBusinessError.STOCK_NOT_ENOUGH, "购买数量不正确或超限");
        }
        // 校验秒杀活动信息
        if (promoId != null) {
            if (promoId.intValue() != itemModel.getPromoModel().getId().intValue()) {
                throw new BusinessException(EnumBusinessError.SECKILL_PARAMETER_ERROR);
            } else if (itemModel.getPromoModel().getStatus().intValue() != 2) {
                throw new BusinessException(EnumBusinessError.SECKILL_PARAMETER_ERROR, "秒杀活动尚未开始");
            }
        }

        boolean result = itemService.decreaseStock(itemId, amount);
        if (!result) {
            throw new BusinessException(EnumBusinessError.STOCK_NOT_ENOUGH);
        }

        OrderModel orderModel = new OrderModel();
        orderModel.setItemId(itemId);
        orderModel.setAmount(amount);
        orderModel.setUserId(userId);
        if (promoId != null) {
            orderModel.setPromoId(promoId);
            orderModel.setItemPrice(itemModel.getPromoModel().getPromoItemPrice());
        } else {
            orderModel.setItemPrice(itemModel.getPrice());
        }
        orderModel.setOrderPrice(orderModel.getItemPrice().multiply(BigDecimal.valueOf(amount)));
        // 生成交易流水号的规则 即为该订单id
        orderModel.setId(this.generateOrderNO());
        OrderDO orderDO = this.convertOrderDOFromOrderModel(orderModel);
        orderDOMapper.insertSelective(orderDO);
        // 同步增加商品的销量
        boolean increaseResult = itemService.increaseSales(itemId, amount);
        if (!increaseResult) {
            LOGGER.error("商品id为:" + itemId + ",增加销量失败!");
        }
        return orderModel;
    }

    // 添加注解是为了保证当创建订单的事务发生回滚不会对该操作造成影响
    // 不会重用创建订单的事务 会重新添加开启一个事务 执行该段的事务完成之后并提交给 创建订单中
    // 每次都是新的事务
    // 每次操作都是一个新的不会进行回滚 保证全局的唯一性
    // 该段代码的bug是：没有设置current_value的最大值 当最大值超过6位时出现
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String generateOrderNO() {
        // 生成订单号一般规则：长度16位
        // 前8位 时间信息
        // 中间6位 自增序列
        // 后2位 分库分表
        StringBuilder orderNO = new StringBuilder();
        LocalDateTime now = LocalDateTime.now();
        String nowTime = now.format(DateTimeFormatter.ISO_DATE).replace("-", "");
        orderNO.append(nowTime);
        // 存放sequence结果
        int sequence = 0;
        SequenceDO sequenceDO = sequenceDOMapper.selectSequenceByName("order_info");
        sequence = sequenceDO.getCurrentValue();
        sequenceDO.setCurrentValue(sequenceDO.getCurrentValue() + sequenceDO.getStep());
        sequenceDOMapper.updateByPrimaryKeySelective(sequenceDO);
        // 转换成String类型
        String sequenceStr = String.valueOf(sequence);
        for (int i = 0; i < 6 - sequenceStr.length(); i++) {
            orderNO.append(0);
        }
        orderNO.append(sequenceStr);
        // 幸运标志数字 暂定
        orderNO.append("16");

        return orderNO.toString();
    }

    private OrderDO convertOrderDOFromOrderModel(OrderModel orderModel) {
        if (orderModel == null) {
            return null;
        }
        OrderDO orderDO = new OrderDO();
        BeanUtils.copyProperties(orderModel, orderDO);
        return orderDO;
    }
}
