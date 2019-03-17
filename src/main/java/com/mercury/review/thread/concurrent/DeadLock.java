package com.mercury.review.thread.concurrent;

/***
 * 线程死锁示例
 */
public class DeadLock {

    private static final Object objA = new Object();
    private static final Object objB = new Object();


    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (objA) {
                try {
                    System.out.println(Thread.currentThread().getName() + "get objectA");
                    Thread.sleep(1000);
                    synchronized (objB) {
                        System.out.println(Thread.currentThread().getName() + "get objectB");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }, "thread-1").start();

        new Thread(() -> {
            try {
                synchronized (objB) {
                    System.out.println(Thread.currentThread().getName() + "get objectB");
                    Thread.sleep(1000);
                    synchronized (objA) {
                        System.out.println(Thread.currentThread().getName() + "get objectA");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "thread-2").start();

    }
}
