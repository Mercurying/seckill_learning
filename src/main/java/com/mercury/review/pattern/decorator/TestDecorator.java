package com.mercury.review.pattern.decorator;


/**
 * 装饰者模式 设计模式
 * 涉及到的角色：
 * 抽象组件:定义一个抽象接口  来规范准备附加功能的类
 * 具体组件: 将要被附加功能的类 实现抽象构件角色接口
 * 抽象装饰者 持有对具体构件角色的引用并定义抽象构件角色一致的接口
 * 具体装饰 实现抽象装饰的角色 负责对具体构件添加额外的功能
 */
public class TestDecorator {
    public static void main(String[] args) {
        Man man = new Man();
        ManDecoratorA manA = new ManDecoratorA();
        ManDecoratorB manB = new ManDecoratorB();
        manA.setPerson(man);
        manB.setPerson(manA);
        manA.eat();
        System.out.println();
        System.out.println("========宇宙无敌分割线=============");
        System.out.println();
        manB.eat();
    }
}
