package com.mercury.review.pattern.proxy;

// DBQueryProxy 是DBQuery的代理类
public class DBQueryProxy implements IDBQuery {
    private DBQuery real;

    @Override
    public String request() {
        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }
}
