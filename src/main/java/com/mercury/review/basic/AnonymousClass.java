package com.mercury.review.basic;

abstract class Person {
    abstract void eat();
}

class Child extends Person {

    @Override
    void eat() {
        System.out.println("今天晚上去吃什么东西啊?");
    }
}

public class AnonymousClass {
    public static void main(String[] args) {
        Person person = new Child();
        person.eat();

        // 方式二
        Person p = new Person() {
            @Override
            void eat() {
                System.out.println("今天晚上不吃饭可以吗?");
            }
        };
        p.eat();
    }
}
