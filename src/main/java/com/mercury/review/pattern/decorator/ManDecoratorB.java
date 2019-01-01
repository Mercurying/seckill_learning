package com.mercury.review.pattern.decorator;

/*concreteDecorator 实体装饰者对象*/
public class ManDecoratorB extends Decorator {
    public void eat() {
        super.eat();
        System.out.println("============ManDecoratorB类==========");
        System.out.println("ManDecoratorB类 调用...");
    }
}
