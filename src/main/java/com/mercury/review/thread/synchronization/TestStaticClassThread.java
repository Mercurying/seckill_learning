package com.mercury.review.thread.synchronization;

public class TestStaticClassThread {
    public static void main(String[] args) {
        SynchronizedOnStaticClass synchronizedClass = new SynchronizedOnStaticClass();
        //  静态class上
        ThreadPrintA threadA = new ThreadPrintA(synchronizedClass);
        threadA.setName("a");
        threadA.start();
        // 静态方法
        ThreadPrintB threadB = new ThreadPrintB(synchronizedClass);
        threadB.setName("b");
        threadB.start();
        //非静态方法
        ThreadPrintC threadC = new ThreadPrintC(synchronizedClass);
        threadC.setName("c");
        threadC.start();

//        String s1 = "abc";
//        String s2 = "abc";
//        System.out.println("String常量池属性测试demo:");
//        System.out.println(s1 == s2);
    }
}
