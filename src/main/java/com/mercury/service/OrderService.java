package com.mercury.service;

import com.mercury.error.BusinessException;
import com.mercury.service.model.OrderModel;

public interface OrderService {
    // 通过创建订单时 秒杀活动判断：
    // 1.通过前端url路径传入秒杀活动id 使用该种方式
    // 2.通过orderServiceImpl内部判断是否存在秒杀活动 若存在则以秒杀活动价格计算
    OrderModel createOrder(Integer userId, Integer itemId, Integer promoId, Integer amount) throws BusinessException;
}
