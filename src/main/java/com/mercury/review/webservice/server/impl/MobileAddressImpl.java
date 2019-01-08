package com.mercury.review.webservice.server.impl;

import com.mercury.review.webservice.common.Mobile;
import com.mercury.review.webservice.common.ServerResponse;
import com.mercury.review.webservice.server.MobileAddress;
import org.apache.commons.lang3.StringUtils;

import javax.jws.WebService;

@WebService
public class MobileAddressImpl implements MobileAddress {
    @Override
    public String getMobileAddress(String mobileNO) {
        System.out.println("receive parameters:" + mobileNO);
        if (StringUtils.isNotBlank(mobileNO)) {
            if (Mobile.MOBILE_NO.equals(mobileNO)) {
                return "手机号:" + mobileNO + ",归属地是:" + "上海移动全球通卡";
            } else {
                return "手机号:" + mobileNO + ",暂无归属地信息";
            }
        } else {
            return ServerResponse.INVALID_PARAMETER.getMsg();
        }
    }
}
