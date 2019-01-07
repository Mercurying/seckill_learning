package com.mercury.review.thread.executor;

public class WorkThread implements Runnable {
    private String command;

    public WorkThread(String command) {
        this.command = command;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + "start time:" + System.currentTimeMillis());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " " + "end time:" + System.currentTimeMillis());

    }

    private void processCommand() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "WorkThread{" +
                "command='" + command + '\'' +
                '}';
    }
}
