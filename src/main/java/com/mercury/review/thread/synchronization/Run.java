package com.mercury.review.thread.synchronization;

public class Run {

    /**
     * synchronized method result:
     * begin do task...
     * 长时间处理任务后从远程返回的值1=TaskName=Thread-0
     * 长时间处理任务后从远程返回的值2=TaskName=Thread-0
     * end do task...
     * begin do task...
     * 长时间处理任务后从远程返回的值1=TaskName=Thread-1
     * 长时间处理任务后从远程返回的值2=TaskName=Thread-1
     * end do task...
     * 执行本次任务耗时:5.000649439s
     * <p>
     * synchronized  代码块 执行结果 result:
     * begin do task...
     * begin do task...
     * 长时间处理任务后从远程返回的值1=TaskName=Thread-1
     * 长时间处理任务后从远程返回的值2=TaskName=Thread-0
     * end do task...
     * 长时间处理任务后从远程返回的值1=TaskName=Thread-0
     * 长时间处理任务后从远程返回的值2=TaskName=Thread-0
     * end do task...
     * 执行本次任务耗时:5.006016961s
     * 从执行结果可以发现：
     * 当一个线程访问一个对象的synchronized同步代码块时，另一个线程任然可以访问该对象其他非synchronized
     * 代码
     * synchronized持有当前调用对象锁 不存在synchronized代码块中就异步执行  在synchronized 代码块中就是同步执行
     */
    public static void main(String[] args) {
        Task task = new Task();
        ThreadA thread1 = new ThreadA(task);
        thread1.start();
        ThreadB thread2 = new ThreadB(task);
        thread2.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long beginTime = CommonUtils.beginTime1;
        if (CommonUtils.beginTime1 > CommonUtils.beginTime2) {
            beginTime = CommonUtils.beginTime2;
        }
        long endTime = CommonUtils.endTime1;
        if (CommonUtils.endTime2 > CommonUtils.endTime1) {
            endTime = CommonUtils.endTime2;
        }
        // 使用下面的写法 执行结果与预期的不同 打印的执行耗时位置不同
        //long beginTime = CommonUtils.beginTime1 < CommonUtils.beginTime2 ? CommonUtils.beginTime1 : CommonUtils.beginTime2;
        //long endTime = CommonUtils.endTime1 < CommonUtils.endTime2 ? CommonUtils.endTime2 : CommonUtils.endTime1;
        System.out.println("执行本次任务耗时:" + ((endTime - beginTime) * Math.pow(10, -9)) + "s");

    }
}
