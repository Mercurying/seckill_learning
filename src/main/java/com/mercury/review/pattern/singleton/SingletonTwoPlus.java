package com.mercury.review.pattern.singleton;


/**
 * 懒汉模式优化 兼容多线程模式调用
 * 通过双重检测+synchronized关键字加锁 volatile关键字的使用 多线程中使用
 */
public class SingletonTwoPlus {

    // 使用volatile关键字保证了当instance变量被初始化成SingletonTwoPlus实例时
    // 多个线程可以正确处理instance实例
    private volatile static SingletonTwoPlus instance;

    private SingletonTwoPlus() {

    }

    // 优化懒汉模式的调用
    public static SingletonTwoPlus getInstance() {
        // 检测实例 如果不存在进入同步代码块中
        if (instance == null) {
            // 只有第一次才彻底执行这里的代码
            synchronized (SingletonTwoPlus.class) {
                // 进入同步代码块中 再次检测实例是否被创建如果没有创建进行创建
                if (instance == null) {
                    instance = new SingletonTwoPlus();
                }
            }
        }
        return instance;
    }
}
