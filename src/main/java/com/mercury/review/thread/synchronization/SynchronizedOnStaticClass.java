package com.mercury.review.thread.synchronization;

public class SynchronizedOnStaticClass {
    public static void printA() {

        // synchronized关键字添加在class级别上
        synchronized (SynchronizedOnStaticClass.class) {
            try {
                System.out.println("线程名称是:" + Thread.currentThread().getName() + "  在时间:" +
                        System.currentTimeMillis() + "进入printA()方法");
                Thread.sleep(2000);
                System.out.println("线程名称是:" + Thread.currentThread().getName() + "  在时间:" +
                        System.currentTimeMillis() + "离开printA()方法");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // synchronized添加到static静态方法上
    public synchronized static void printB() {
        System.out.println("线程名称是:" + Thread.currentThread().getName() + "  在时间:" + System.currentTimeMillis() + "进入" + "printB()方法");
        System.out.println("线程名称是:" + Thread.currentThread().getName() + "  在时间:" + System.currentTimeMillis() + "离开" + "printB()方法");
    }

    // 添加到非静态方法上
    public synchronized void printC() {
        System.out.println("线程名称是:" + Thread.currentThread().getName() + "  在时间:" + System.currentTimeMillis() + "进入" + "printC()方法");
        System.out.println("线程名称是:" + Thread.currentThread().getName() + "  在时间:" + System.currentTimeMillis() + "离开" + "printC()方法");
    }
}
