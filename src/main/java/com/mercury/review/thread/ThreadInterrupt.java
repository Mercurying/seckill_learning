package com.mercury.review.thread;

public class ThreadInterrupt extends Thread {
    public void run() {
        super.run();
        for (int i = 0; i < 10000000; i++) {
            if (this.isInterrupted()) {
                System.out.println("已经是停止状态了,我要退出了.");
                break;
            }
            System.out.println("i=" + (i + 1));
        }
        System.out.println("看到这句话说明线程并未终止...");
    }

    // 测试线程退出interrupt是否生效
    public static void main(String[] args) {
        ThreadInterrupt thread = new ThreadInterrupt();
        thread.start();
        try {
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
