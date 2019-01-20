package com.mercury.review.reflection;

/**
 * 测试java 反射使用方式
 */
public class Teacher {

    public Teacher() {
        System.out.println("默认无参构造函数...");
    }

    public Teacher(char name) {
        System.out.println("一个参数构造函数,参数name=" + name);
    }

    public Teacher(String name, Integer age) {
        System.out.println("多个参数的构造函数,name=" + name + ",age=" + age);
    }

    protected Teacher(String name) {
        System.out.println("受保护的构造函数,name=" + name);
    }

    private Teacher(Integer age) {
        System.out.println("私有构造函数,age=" + age);
    }

}
