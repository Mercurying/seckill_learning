package com.mercury.review.thread.volatilekeyword;

// 测试volatile关键字是否可以确保原子性
// 通过测试结果可以知道无法确保变量的原子性操作

/**
 *
 count=99
 count=70
 count=68
 count=68
 count=68
 count=68
 count=99
 count=68
 count=99
 count=99
 count=68
 count=6
 count=68
 count=99
 */
public class MyThread extends Thread {
    public static volatile int count;

    private static void addCount() {
        for (int i = 0; i < 100; i++) {
            count = i;
        }
        System.out.println("count=" + count);
    }

    public void run() {
        super.run();
        addCount();
    }


    public static void main(String[] args) {
        MyThread[] myThreads = new MyThread[100];
        for (int i = 0; i < 100; i++) {
            myThreads[i] = new MyThread();
        }

        for (MyThread thread : myThreads) {
            thread.start();
        }

    }
}
