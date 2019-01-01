package com.mercury.review.thread.synchronization;

public class ThreadA extends Thread {
    private Task task;

    public ThreadA(Task task) {
        super();
        this.task = task;
    }

    public void run() {
        super.run();
        CommonUtils.beginTime1 = System.nanoTime();
        task.doLongTimeTask();
        CommonUtils.endTime1 = System.nanoTime();
    }
}
