package com.mercury.review.pattern.singleton;

/**
 * 饿汉模式 通过枚举方式调用
 */
public enum SingletonOneEnum {
    INSTANCE;

    public void doSomething() {
        System.out.println("枚举方式实例单例模式调用");
    }
}
