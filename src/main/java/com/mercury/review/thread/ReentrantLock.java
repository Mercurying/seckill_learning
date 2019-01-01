package com.mercury.review.thread;


/*测试 可重入锁*/
public class ReentrantLock {

    public void service1() {
        System.out.println("service1");
        service2();
    }

    public void service2() {
        System.out.println("service2");
        service3();
    }

    public void service3() {
        System.out.println("service3");
    }
}
