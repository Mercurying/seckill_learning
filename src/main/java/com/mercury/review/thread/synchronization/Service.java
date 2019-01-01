package com.mercury.review.thread.synchronization;

public class Service {
    public void testMethod1(MyObject obj) {
        // 通过synchronized关键字锁对象
        synchronized (obj) {
            try {

                System.out.println("testMethod1 __getLock time=" + System.currentTimeMillis() + "  run threadName" +
                        Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("testMethod1 releaseLock time=" + System.currentTimeMillis() + "  run threadName" +
                        Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
