package com.mercury.review.pattern.builder;

// 抽象构造者
public abstract class MealBuilder {
    Meal meal = new Meal();

    public abstract void builderFood();

    public abstract void builderDrink();

    public Meal getMeal() {
        return meal;
    }
}
