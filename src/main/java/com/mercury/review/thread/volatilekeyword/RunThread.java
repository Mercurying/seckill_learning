package com.mercury.review.thread.volatilekeyword;

public class RunThread extends Thread {
    // 对isRunning 添加与不添加volatile关键字测试
    // 当不对isRunning添加volatile关键字 在while语句中添加打断语句
    // 也可以确保变量的可见性 例如添加 System.println.out() 或者sleep
    // 原理是jvm会尽力保证内存的可见性  即便这个变量没有添加同步关键字
    // 换句话说：只要cpu有时间 jvm会尽力去保证变量值的更新 如果cpu一种处理其他事情
    // 没有时间去管理 占用cpu
    private volatile boolean isRunning = true;
    int m;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("进入run方法中");
        while (isRunning) {
            int a = 2;
            int b = 3;
            int c = a + b;
            m = c;
        }
        System.out.println(m);
        System.out.println("线程被停止了...");
    }
}
