package com.mercury.review.thread.synchronization;

public class Task {
    private String data1;
    private String data2;

    // 1.测试当使用synchronized关键字添加到方法声明上 该方法是耗时操作时性能问题
    // 2.修改成同步代码块进行执行
    public void doLongTimeTask() {
        try {
            System.out.println("begin do task...");
            Thread.sleep(5000);
            String privateData1 = "长时间处理任务后从远程返回的值1=TaskName=" + Thread.currentThread().getName();
            String privateData2 = "长时间处理任务后从远程返回的值2=TaskName=" + Thread.currentThread().getName();
            // 添加上synchronized代码块进行执行
            synchronized (this) {
                data1 = privateData1;
                data2 = privateData2;
            }
            System.out.println(data1);
            System.out.println(data2);
            System.out.println("end do task...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
