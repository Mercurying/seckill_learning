package com.mercury.review.pattern.factory;

public class SquareFactory implements FactoryMethod {
    @Override
    public Shape getShape() {
        return new Square();
    }
}
