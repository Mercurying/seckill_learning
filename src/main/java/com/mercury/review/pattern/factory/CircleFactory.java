package com.mercury.review.pattern.factory;


// 单独实现圆图形工厂类
public class CircleFactory implements FactoryMethod {
    @Override
    public Shape getShape() {
        return new Circle();
    }
}
