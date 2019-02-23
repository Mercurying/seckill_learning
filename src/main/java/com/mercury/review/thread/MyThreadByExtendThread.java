package com.mercury.review.thread;

/*多线程实现方式之一*/
public class MyThreadByExtendThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThreadByExtendThread");
    }
}
