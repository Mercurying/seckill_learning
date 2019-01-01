package com.mercury.review.pattern.singleton;

/**
 * 单例模式：该类只能被创建一次
 * 此对应的是饿汉模式 线程安全 加载到该类 Singleton对象就被创建而不论是否调用
 * jvm加载到该类时就被创建了 以空间换时间
 * 全局的单例实例在类被装载时构建
 * 比较耗内存
 */
public class SingletonOne {
    // 在静态初始化器中创建单例模式 这段代码保证了线程安全性
    private static final SingletonOne instance = new SingletonOne();

    // 添加私有构造器确保只能被实例化一次
    private SingletonOne() {

    }

    // 提供给调用方调用
    public static SingletonOne getInstance() {
        return instance;
    }
}
