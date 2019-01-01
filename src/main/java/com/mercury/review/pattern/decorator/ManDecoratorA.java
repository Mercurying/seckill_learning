package com.mercury.review.pattern.decorator;

/*concreteDecorator 实体装饰者对象*/
public class ManDecoratorA extends Decorator {

    public void eat() {
        super.eat();
        againEat();
        System.out.println("==========ManDecoratorA类============");
        System.out.println("ManDecoratorA类 调用...");
    }

    private void againEat() {
        System.out.println("吃完饭,再来锻炼身体哈哈哈...");
    }
}
