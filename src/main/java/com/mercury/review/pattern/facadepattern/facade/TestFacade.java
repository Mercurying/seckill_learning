package com.mercury.review.pattern.facadepattern.facade;


/**
 * 门面模式
 * 作用：松耦合 简单易用 更好的划分访问层次
 * 使得客户端和子系统之间解耦 让子系统内部的模块功能更容易扩展和维护;
 */
public class TestFacade {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
        System.out.println("==================");
        computer.shutDown();
    }
}
