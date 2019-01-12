package com.mercury.review.thread.atomic;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mercury
 * @version v1.0
 * @description 熟悉java.util.concurrent.atomic 用法
 * AtomicInteger类常用方法
 * public final int get 获取当前值
 * public final int getAndSet(int newValue) 获取当前值,并设置新值
 * public final int getAndIncrement() 获取当前的值并进行自增操作
 * public final int getAndDecrement() 获取当前值并进行自减操作
 * public final int getAndAdd(int delta) 获取当前值并加上预期的值
 * boolean compareAndSet(int expect,int update) 如果输入的数值等于预期值 则以原子的方式将该值设置为输入值
 * public final void lazySet(int newValue) 最终设置newValue 使用lazySet 设置之后可能导致其他线程在之后的一小段时间内还是可以读到旧值
 * @date 2019/1/9 21:55
 */
public class AtomicIntegerUsage {
    public static void main(String[] args) {
        // 测试基本方法
        atomicIntegerUsageMethod();

    }

    public static void atomicIntegerUsageMethod() {
        int temporaryValue = 0;
        AtomicInteger i = new AtomicInteger(0);
        // Atomically sets to the given value and returns the old value.
        temporaryValue = i.getAndSet(3);
        // temporaryValue:0 i:3
        System.out.println("temporaryValue:" + temporaryValue + " " + "i:" + i);
        temporaryValue = i.getAndIncrement();
        // temporaryValue:3 i:4
        System.out.println("temporaryValue:" + temporaryValue + " " + "i:" + i);
        temporaryValue = i.getAndAdd(5);
        // temporaryValue:4 i:9
        System.out.println("temporaryValue:" + temporaryValue + " " + "i:" + i);
    }
}
