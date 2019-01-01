package com.mercury.review.thread.synchronization;

public class ThreadB extends Thread {
    private Task task;

    public ThreadB(Task task) {
        super();
        this.task = task;
    }

    public void run() {
        super.run();
        CommonUtils.beginTime2 = System.nanoTime();
        task.doLongTimeTask();
        CommonUtils.endTime2 = System.nanoTime();
    }
}
