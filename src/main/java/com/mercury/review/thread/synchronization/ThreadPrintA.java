package com.mercury.review.thread.synchronization;

public class ThreadPrintA extends Thread {

    private SynchronizedOnStaticClass synchronizedOnStaticClass;

    public ThreadPrintA(SynchronizedOnStaticClass synchronizedOnStaticClass) {
        super();
        this.synchronizedOnStaticClass = synchronizedOnStaticClass;
    }

    public void run(){
        super.run();
        synchronizedOnStaticClass.printA();
    }

}
