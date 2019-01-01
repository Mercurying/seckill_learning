package com.mercury.review.pattern.proxy;


// 真实主题
public class DBQuery implements IDBQuery {

    public DBQuery(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String request() {
        return "query result:successful.";
    }
}
