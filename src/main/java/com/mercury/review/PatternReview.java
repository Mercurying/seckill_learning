package com.mercury.review;

import com.mercury.review.pattern.singleton.SingletonOne;
import com.mercury.review.pattern.singleton.SingletonOneEnum;
import com.mercury.review.pattern.singleton.SingletonTwo;
import com.mercury.review.pattern.singleton.SingletonTwoPlus;

/**
 * 23种常见设计模式复习
 * 分类：
 * 1.创建型模式
 * 1.1单例模式 singleton 一般分为 饿汉模式[线程安全] 懒汉模式[涉及到线程安全]
 * 1.2工厂模式 分为简单工厂模式[暴露统一工厂方法] 工厂方法模式[为每一个对象创建一个工厂] 抽象工厂模式[
 * 一个工厂生产多种产品至少要2种产品]
 * 1.3建造者模式 又名生成器模式 是一个对象构建模式 它可以将复杂对象的建造过程抽象 出来 使这个抽象过程的不同实现
 * 方法 可以构造出不同表现形式的对象
 * 注意与工厂模式区别：抽象工厂模式生成的是一个产品族 一系列产品  建造者模式是通过零部件组装成复杂的产品
 * 原型模式
 * <p>
 * 2.结构型模式
 * 3.行为性模式
 */
public class PatternReview {

    public static void main(String[] args) {


        // PatternReview.testSingleton2();
        // PatternReview.testSingleton2Plus();
        PatternReview.testSingletonOneEnum();
    }

    private static void testSingleton1() {
        System.out.println("========测试单例模式调用方法===========");
        SingletonOne singleton1 = SingletonOne.getInstance();
        SingletonOne singleton2 = SingletonOne.getInstance();
        System.out.println("singleton1:" + singleton1);
        System.out.println("singleton2:" + singleton2);
        System.out.println("========singleton1与singleton2是否相同=====");
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1.equals(singleton2));
    }

    private static void testSingleton2() {
        System.out.println("=============测试单例模式之懒汉模式调用方式=============");
        SingletonTwo singletonTwo1 = SingletonTwo.getInstance();
        SingletonTwo singletonTwo2 = SingletonTwo.getInstance();
        System.out.println("=========singleton对象显示=============");
        System.out.println("singletonTwo1:" + singletonTwo1);
        System.out.println("singletonTwo2:" + singletonTwo2);
        System.out.println("==============对象是否相等=========");
        System.out.println(singletonTwo1 == singletonTwo2);
        System.out.println(singletonTwo1.equals(singletonTwo2));
    }

    private static void testSingleton2Plus() {
        System.out.println("=====测试单例模式之懒汉模式优化调用方式=====");
        SingletonTwoPlus instance1 = SingletonTwoPlus.getInstance();
        SingletonTwoPlus instance2 = SingletonTwoPlus.getInstance();
        System.out.println("=============是否相等============");
        System.out.println(instance1 == instance2);
        System.out.println(instance1.equals(instance2));

    }

    private static void testSingletonOneEnum() {
        System.out.println("========测试枚举方式实现单例模式===========");
        SingletonOneEnum instance = SingletonOneEnum.INSTANCE;
        instance.doSomething();
    }

}
