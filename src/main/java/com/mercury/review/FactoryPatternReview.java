package com.mercury.review;


import com.mercury.review.pattern.factory.*;

/**
 * 工厂模式复习
 * 工厂模式强调：两个类A和B之间的关系应该仅仅是A创建B或是A使用B，而不能两种关系都有
 * 目的：使用的系统更加符合"单一职责原则"
 * 一般而言：类A与类B之间的关系 要么是A创建B 要么是A使用B 最好不要同时既创建一个对象并使用一个对象
 * 将对象的创建和使用分离 解耦
 * 简单工厂模式 使用较少
 * 工厂方法模式 使用最多 不是在统一提供一个工厂类 而是针对不同的对象提供不同的工厂实现
 * 抽象工厂模式 抽象工厂角色 具体工厂类 抽象产品角色 具体产品角色
 *
 */
public class FactoryPatternReview {

    public static void main(String[] args) {
        // 简单工厂模式调用
        // FactoryPatternReview.testSimpleFactory();
        // 简单工厂模式使用反射进行调用
        // FactoryPatternReview.testSimpleFactoryReflection();
        // 工厂方法模式调用方式
        FactoryPatternReview.testFactoryMethod();

    }


    private static void testSimpleFactory() {
        Shape circle = ShapeSimpleFactory.getShape("circle");
        circle.draw();
        Shape rectangle = ShapeSimpleFactory.getShape("rectangle");
        rectangle.draw();
        Shape square = ShapeSimpleFactory.getShape("square");
        square.draw();
    }

    // 通过反射方法进行调用
    private static void testSimpleFactoryReflection() {
        Circle circle = (Circle) ShapeSimpleFactoryReflection.getClass(Circle.class);
        circle.draw();
        Rectangle rectangle = (Rectangle) ShapeSimpleFactoryReflection.getClass(Rectangle.class);
        rectangle.draw();
        Square square = (Square) ShapeSimpleFactoryReflection.getClass(Square.class);
        square.draw();
    }

    private static void testFactoryMethod() {
        FactoryMethod circleFactory = new CircleFactory();
        Circle circle = (Circle) circleFactory.getShape();
        circle.draw();


    }

}
