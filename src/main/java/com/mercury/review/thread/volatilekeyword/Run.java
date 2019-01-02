package com.mercury.review.thread.volatilekeyword;

public class Run {
    // 当 isRunning不添加volatile关键字 程序进入死循环状态
    // 执行结果：
    // 进入run方法中
    // 已经对isRunning进行赋值为false
    // 添加volatile关键字执行结果：
    // 进入run方法中
    // 已经对isRunning进行赋值为false
    // 5
    // 线程被停止了...
    public static void main(String[] args) throws InterruptedException {
        RunThread thread = new RunThread();
        thread.start();
        Thread.sleep(1000);
        thread.setRunning(false);
        System.out.println("已经对isRunning进行赋值为false");
    }
}
