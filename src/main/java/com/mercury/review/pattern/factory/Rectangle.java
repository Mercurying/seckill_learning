package com.mercury.review.pattern.factory;

public class Rectangle implements Shape {

    public Rectangle() {

    }

    @Override
    public void draw() {
        System.out.println("draw Rectangle");
    }
}
