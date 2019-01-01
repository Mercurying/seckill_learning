package com.mercury.review.pattern.factory;

public class Square implements Shape {
    public Square() {

    }

    @Override
    public void draw() {
        System.out.println("draw Square");
    }
}
