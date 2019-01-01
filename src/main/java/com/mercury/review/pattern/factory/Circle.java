package com.mercury.review.pattern.factory;

public class Circle implements Shape {
    public Circle() {

    }

    @Override
    public void draw() {
        System.out.println("draw Circle");
    }
}
