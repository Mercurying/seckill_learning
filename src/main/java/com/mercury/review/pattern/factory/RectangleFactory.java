package com.mercury.review.pattern.factory;

public class RectangleFactory implements FactoryMethod {
    @Override
    public Shape getShape() {
        return new Rectangle();
    }
}
