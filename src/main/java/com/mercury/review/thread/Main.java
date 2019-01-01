package com.mercury.review.thread;

public class Main {
    /**
     * result：
     * 执行多线程...
     * MyThreadByExtendThread
     * <p>
     * <p>
     * testShareVariableThread执行结果：
     * 计算结果不正确
     * 分析：jvm操作中 count--；
     * 实际上是分为三步进行计算：
     * 1.取得count的值
     * 2.计算count-1
     * 3.对count进行赋值
     * 解决办法是通过使用 synchronized关键字
     * 14:22:57.242 [a] INFO com.mercury.review.thread.ShareVariableThread - 由a计算,count=4
     * 14:22:57.243 [c] INFO com.mercury.review.thread.ShareVariableThread - 由c计算,count=4
     * 14:22:57.242 [d] INFO com.mercury.review.thread.ShareVariableThread - 由d计算,count=4
     * 14:22:57.242 [e] INFO com.mercury.review.thread.ShareVariableThread - 由e计算,count=4
     * 14:22:57.242 [b] INFO com.mercury.review.thread.ShareVariableThread - 由b计算,count=4
     */

    public static void main(String[] args) {

        // testVariableThread();


        testShareVariableThread();
    }


    public static void testShareVariableThread() {
        ShareVariableThread a = new ShareVariableThread("a");
        ShareVariableThread b = new ShareVariableThread("b");
        ShareVariableThread c = new ShareVariableThread("c");
        ShareVariableThread d = new ShareVariableThread("d");
        ShareVariableThread e = new ShareVariableThread("e");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

    }

    public static void testVariableThread() {

        MyThread thread1 = new MyThread("a");
        MyThread thread2 = new MyThread("b");
        MyThread thread3 = new MyThread("c");
        thread1.start();
        thread2.start();
        thread3.start();

    }


    public static void helloThread() {
        if (false) {
            // 实现方式一
            MyThreadByExtendThread thread = new MyThreadByExtendThread();
            thread.start();
        } else {
            // 实现方式二
            MyThreadByImplementsRunnable myThread = new MyThreadByImplementsRunnable();
            Thread thread = new Thread(myThread);
            thread.start();
        }
        System.out.println("执行多线程...");
    }
}
