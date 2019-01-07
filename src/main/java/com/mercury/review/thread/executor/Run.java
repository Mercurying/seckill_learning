package com.mercury.review.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Run {
    // 线程池使用简单实例
    public static void main(String[] args) {

        try {
            scheduleThreadPoolDemo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private static void scheduleThreadPoolDemo() throws InterruptedException {
        // 创建一个scheduledThreadPool对象
        ScheduledExecutorService scheduleThreadPool = Executors.newScheduledThreadPool(5);
        System.out.println("currentTime:" + System.currentTimeMillis());
        for (int i = 0; i < 3; i++) {
            Thread.sleep(2000);
            WorkThread worker = new WorkThread("do heavy tasks");
            // 创建并执行在给定延迟后启用单次操作
            scheduleThreadPool.schedule(worker, 10, TimeUnit.SECONDS);
        }
        Thread.sleep(6000);
        System.out.println("after currentTime:" + System.currentTimeMillis());
        scheduleThreadPool.shutdown();
        while (!scheduleThreadPool.isTerminated()) {

        }
        System.out.println("scheduleThreadPool finished...");
    }

    private static void fixedThreadPoolDemo() {
        // 使用线程池工具类Executors创建一个FixedThreadPool线程池对象
        // 使用fixedThreadPool 创建指定数量的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkThread("NO" + i);
            executor.execute(worker);
        }
        // 终止线程
        executor.shutdown();
        // isTerminated()判断当前线程是否已经完成终止
        while (!executor.isTerminated()) {

        }
        System.out.println("Finished all threads");
    }
}
