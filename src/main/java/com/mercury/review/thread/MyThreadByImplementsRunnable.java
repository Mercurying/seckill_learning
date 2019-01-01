package com.mercury.review.thread;

/*实现Runnable接口实现多线程方式*/
public class MyThreadByImplementsRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyThread...");
    }
}
