package com.mercury.review.thread.executor;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    /**
     * 四种常见线程池操作
     * newCachedThreadPool
     * newFixedThreadPool
     * newScheduledThreadPool
     * newSingerThreadPool
     * 说明：
     * newCachedThreadPool 线程池
     * 创建一个可缓存的线程池 如果线程池的大小超过了处理任务所需要的线程 那么就会回收部分空闲（60秒不执行任务）
     * 此线程不会对线程池大小限制 线程池大小完全依赖于操作系统（或者说是JVM）能够创建的最大线程数.
     * newFixedThreadPool 线程池
     * 创建固定大小的线程池 每次提交一个任务就创建一个线程 直到线程达到线程池的最大大小
     * 线程池的大小一旦达到最大值就会保持不变  如果某个线程因为执行异常而结束 那么线程池会补充一个新线程
     * newScheduledThreadPool 线程池
     * 创建一个定长的线程池 支持定时及周期性任务执行 延迟执行
     * newSingleThreadPool 线程池
     * 创建一个单线程化的线程池 它只会用唯一的工作线程来执行任务 保证所有任务按照指定顺序执行
     *
     * @param args
     */
    public static void main(String[] args) {
        testSingleThreadPool();
    }


    // cachedThreadPool 测试
    private static void testCachedThreadPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("执行:" + index + ",线程名:" + threadName);
                }
            });

        }
        cachedThreadPool.shutdown();
        // 如果所有线程都已经停止之后进行执行以下操作
        while (!cachedThreadPool.isTerminated()) {

        }
        System.out.println("所有线程已经执行 bye bye...");
    }


    // 由于线程池的大小是3 每个任务输出index后sleep2秒 所以是每秒打印3个数字
    public static void testFixedThreadPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String threadName = Thread.currentThread().getName();
                        System.out.println("执行:" + index + ",线程名称为:" + threadName);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        // 关闭所有线程
        fixedThreadPool.shutdown();
        while (!fixedThreadPool.isTerminated()) {

        }
        System.out.println("所有线程执行完成...");
    }

    private static void testScheduleThreadPool() {
        // 注意这里是使用ScheduleExecutorService 进行接收 ScheduledExecutorService是继承自ExecutorService接口
        ScheduledExecutorService scheduleThreadPool = Executors.newScheduledThreadPool(5);
        System.out.println("开始时间:" + new Date());
        scheduleThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + "延迟5秒执行");
            }
        }, 5, TimeUnit.SECONDS);
        System.out.println("执行时间:" + new Date());
        scheduleThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + "延迟1秒后每3秒执行一次");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }

    private static void testSingleThreadPool() {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String threadName = Thread.currentThread().getName();
                        System.out.println("执行:" + index + ",线程名称是:" + threadName);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        singleThreadPool.shutdown();
        while (!singleThreadPool.isTerminated()) {

        }
        System.out.println("所有线程执行完毕...");

    }
}
