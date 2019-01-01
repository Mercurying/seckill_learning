package com.mercury.review.thread;

public class ThreadB extends Thread {

    private HasSelfPrivateNum numRef;

    public ThreadB(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    public void run() {
        super.run();
        numRef.addNum("b");
    }
}
