package com.mercury.review.thread.synchronization;

public class ThreadPrintB extends Thread {
    private SynchronizedOnStaticClass synchronizedOnStaticClass;

    public ThreadPrintB(SynchronizedOnStaticClass synchronizedOnStaticClass) {
        super();
        this.synchronizedOnStaticClass = synchronizedOnStaticClass;
    }

    public void run() {
        super.run();
        synchronizedOnStaticClass.printB();
    }
}
