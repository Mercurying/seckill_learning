package com.mercury.review.pattern.singleton;

/**
 * 登记式/静态内部类方式调用
 * 懒汉模式使用内部类进行创建被调用 是线程安全的
 */
public class SingletonTwoInner {
    private static class SingletonHolder {
        private static final SingletonTwoInner INSTANCE = new SingletonTwoInner();
    }

    private SingletonTwoInner() {

    }

    // 只有显示的调用getInstance方法 才会装载SingletonHolder类 从而实例化instance
    public static final SingletonTwoInner getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
