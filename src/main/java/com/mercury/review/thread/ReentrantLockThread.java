package com.mercury.review.thread;

public class ReentrantLockThread extends Thread {

    private ReentrantLock rLock;

    public ReentrantLockThread(ReentrantLock rLock) {
        super();
        this.rLock = rLock;

    }

    public void run() {
        super.run();
        rLock.service1();
    }

    // 测试可重入锁调用

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ReentrantLockThread thread = new ReentrantLockThread(lock);
        thread.start();
    }

}
