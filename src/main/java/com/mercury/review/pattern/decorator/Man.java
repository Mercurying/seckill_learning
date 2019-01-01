package com.mercury.review.pattern.decorator;
/*concreteComponent*/
public class Man implements Person {
    @Override
    public void eat() {
        System.out.println("上帝在吃饭...");
    }
}
