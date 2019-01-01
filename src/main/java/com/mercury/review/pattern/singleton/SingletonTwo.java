package com.mercury.review.pattern.singleton;

/**
 * 单例模式懒汉模式
 * 全局的单例模式在第一次调用时构建 不是jvm在加载到该类时就创建出该实例
 */
public class SingletonTwo {
    private static SingletonTwo instance;

    private SingletonTwo() {

    }

    // 没有加上synchronized 同步锁是线程不安全的 jdk1.6优化该关键字 偏重量级锁
    // 解决方案是：直接给该方法加上同步锁 或者加在局部区域 synchronized
    public static synchronized SingletonTwo getInstance() {
        if (instance == null) {
            instance = new SingletonTwo();
        }
        return instance;
    }
}
