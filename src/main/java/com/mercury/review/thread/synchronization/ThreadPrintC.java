package com.mercury.review.thread.synchronization;

public class ThreadPrintC extends Thread {
    private SynchronizedOnStaticClass synchronizedOnStaticClass;

    public ThreadPrintC(SynchronizedOnStaticClass synchronizedOnStaticClass) {
        super();
        this.synchronizedOnStaticClass = synchronizedOnStaticClass;
    }

    public void run() {
        super.run();
        synchronizedOnStaticClass.printC();
    }
}
