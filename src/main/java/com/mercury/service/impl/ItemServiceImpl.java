package com.mercury.service.impl;

import com.mercury.dao.ItemDOMapper;
import com.mercury.dao.ItemStockDOMapper;
import com.mercury.dataobject.ItemDO;
import com.mercury.dataobject.ItemStockDO;
import com.mercury.error.BusinessException;
import com.mercury.error.EnumBusinessError;
import com.mercury.service.ItemService;
import com.mercury.service.PromoService;
import com.mercury.service.model.ItemModel;
import com.mercury.service.model.PromoModel;
import com.mercury.validator.ValidationResult;
import com.mercury.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ValidatorImpl validator;
    @Autowired
    private ItemDOMapper itemDOMapper;
    @Autowired
    private ItemStockDOMapper itemStockDOMapper;
    @Autowired
    private PromoService promoService;

    // 确保事务操作
    @Transactional
    @Override
    public ItemModel createItem(ItemModel itemModel) throws BusinessException {
        // 1.校验入参
        // 2.转化ItemModel-->dataObject
        // 3.写入数据库
        // 4.返回创建完成后的实体对象

        ValidationResult validationResult = validator.validate(itemModel);
        if (validationResult.getHasErrors()) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR, validationResult.getErrorMsg());
        }

        ItemDO itemDO = this.convertItemDOFromItemModel(itemModel);
        itemDOMapper.insertSelective(itemDO);
        // 由于设置自增属性 插入数据库完成之后 可以通过itemDO取到自增后的id值
        itemModel.setId(itemDO.getId());
        ItemStockDO itemStockDO = this.convertItemStockDOFromItemModel(itemModel);
        itemStockDOMapper.insertSelective(itemStockDO);

        return this.getItemById(itemModel.getId());
    }

    @Override
    public List<ItemModel> listItem() {

        List<ItemDO> itemDOList = itemDOMapper.listItem();
        // 此处使用纳姆达表达式流特性处理集合
        List<ItemModel> itemModelList = itemDOList.stream().map(itemDO -> {
            ItemStockDO itemStockDO = itemStockDOMapper.selectByPrimaryKey(itemDO.getId());
            ItemModel itemModel = this.convertModelFromDataObject(itemDO, itemStockDO);
            return itemModel;
        }).collect(Collectors.toList());
        return itemModelList;
    }

    @Override
    public ItemModel getItemById(Integer id) {

        ItemDO itemDO = itemDOMapper.selectByPrimaryKey(id);
        if (itemDO == null) {
            return null;
        }
        // 根据itemId查找库存信息
        // 之前这里一直返回null值由于mapper中语句出错导致 自动的生成的id 变成了" id"
        // 获取商品库存信息
        ItemStockDO itemStockDO = itemStockDOMapper.selectByItemId(itemDO.getId());
        ItemModel itemModel = this.convertModelFromDataObject(itemDO, itemStockDO);
        // 判断商品是否存在秒杀活动信息
        PromoModel promoModel = promoService.getPromoByItemId(itemModel.getId());
        if (promoModel != null && promoModel.getStatus().intValue() != 3) {
            // 存在未结束的秒杀活动
            itemModel.setPromoModel(promoModel);
        }
        return itemModel;
    }

    @Override
    public ItemStockDO getItemStockById(Integer id) {
        // 测试xml文件对应的接口是否正常
        ItemStockDO itemStockDO = itemStockDOMapper.selectByPrimaryKey(id);
        return itemStockDO;
    }

    @Transactional
    @Override
    public boolean decreaseStock(Integer itemId, Integer amount) {
        // 如果影响行数大于0则表明 更新成功.
        int rowResult = itemStockDOMapper.decreaseStock(itemId, amount);
        return rowResult > 0;
    }


    @Transactional
    @Override
    public boolean increaseSales(Integer itemId, Integer amount) {
        // 更新商品对应的销量信息
        int rowResult = itemDOMapper.increaseSales(itemId, amount);
        return rowResult > 0;
    }


    private ItemDO convertItemDOFromItemModel(ItemModel itemModel) {
        if (itemModel == null) {
            return null;
        }
        ItemDO itemDO = new ItemDO();
        // 如果对应的属性类型不同不会进行copy操作
        BeanUtils.copyProperties(itemModel, itemDO);
        // 由于 ItemDO中price与ItemModel中price都对应起来了此处不需要进行类型转换成BigDecimal
        return itemDO;
    }

    private ItemStockDO convertItemStockDOFromItemModel(ItemModel itemModel) {
        if (itemModel == null) {
            return null;
        }
        ItemStockDO itemStockDO = new ItemStockDO();
        itemStockDO.setStock(itemModel.getStock());
        itemStockDO.setItemId(itemModel.getId());
        return itemStockDO;
    }


    private ItemModel convertModelFromDataObject(ItemDO itemDO, ItemStockDO itemStockDO) {
        if (itemDO == null) {
            return null;
        }
        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(itemDO, itemModel);
        if (itemStockDO != null) {
            itemModel.setStock(itemStockDO.getStock());
        }
        return itemModel;
    }

}
