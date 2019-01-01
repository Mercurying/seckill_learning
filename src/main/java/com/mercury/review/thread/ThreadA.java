package com.mercury.review.thread;

public class ThreadA extends Thread {

    private HasSelfPrivateNum numRef;

    public ThreadA(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    public void run() {
        super.run();
        numRef.addNum("a");
    }

}
