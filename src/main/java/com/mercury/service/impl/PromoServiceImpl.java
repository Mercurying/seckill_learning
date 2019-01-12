package com.mercury.service.impl;

import com.mercury.dao.PromoDOMapper;
import com.mercury.dataobject.PromoDO;
import com.mercury.service.PromoService;
import com.mercury.service.model.PromoModel;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("promoService")
public class PromoServiceImpl implements PromoService {

    @Autowired
    private PromoDOMapper promoDOMapper;

    @Override
    public PromoModel getPromoByItemId(Integer itemId) {

        PromoDO promoDO = promoDOMapper.selectPromoByItemId(itemId);

        PromoModel promoModel = convertModelFromDataObject(promoDO);
        // 处理符合条件的秒杀活动 并返回给前端展示
        if (promoModel == null) {
            return null;
        }
        // 其中录入秒杀开始时间<=秒杀结束时间
        if (promoModel.getStartDate().isAfterNow()) {
            // 未开始
            promoModel.setStatus(1);
        } else if (promoModel.getEndDate().isBeforeNow()) {
            // 已结束
            promoModel.setStatus(3);
        } else {
            // 正在进行中
            promoModel.setStatus(2);
        }

        return promoModel;
    }

    private PromoModel convertModelFromDataObject(PromoDO promoDO) {
        if (promoDO == null) {
            return null;
        }
        PromoModel promoModel = new PromoModel();
        BeanUtils.copyProperties(promoDO, promoModel);
        // 将数据库中返回的Date类型转换成model中DateTime类型
        promoModel.setStartDate(new DateTime(promoDO.getStartDate()));
        promoModel.setEndDate(new DateTime(promoDO.getEndDate()));
        return promoModel;
    }
}
