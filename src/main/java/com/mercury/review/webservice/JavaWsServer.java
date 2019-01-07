package com.mercury.review.webservice;

import com.mercury.review.webservice.server.impl.MobileAddressImpl;

import javax.xml.ws.Endpoint;

public class JavaWsServer {
    public static void main(String[] args) {

        // 参数1：暴露的地址 一般形式是：ip+端口+服务名
        // 参数2: 传入实例
        // 测试是否成功 可以直接访问 http://127.0.0.1:8888/mobile?wsdl 返回xml说明页面
        Endpoint.publish("http://192.168.220.1:8888/mobile", new MobileAddressImpl());
        System.out.println("webService服务启动成功...");

    }
}
