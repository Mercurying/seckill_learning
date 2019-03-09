package com.mercury.review;

/**
 * 从jdk1.8版本  接口中是可以进行声明方法实现的
 */
public interface ITestInterfaceImplement {

    void add(Integer a, Integer b);

    public static final String USERNAME = "username";

    public static void say() {
        System.out.println("hello world!");
    }

    public static void main(String[] args) {
        say();
    }
}
