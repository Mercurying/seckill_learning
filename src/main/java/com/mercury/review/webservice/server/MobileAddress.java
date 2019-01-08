package com.mercury.review.webservice.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MobileAddress {
    @WebMethod
    String getMobileAddress(String mobileNO);
}
