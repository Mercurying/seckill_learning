package com.mercury.service;

import com.mercury.service.model.PromoModel;

public interface PromoService {

    // 根据商品id获取该商品即将进行或正在进行的秒杀活动情况
    PromoModel getPromoByItemId(Integer itemId);
}
