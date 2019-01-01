package com.mercury.review.pattern.builder;

public class MealA extends MealBuilder {
    @Override
    public void builderFood() {
        meal.setFood("薯条");
    }

    @Override
    public void builderDrink() {
        meal.setDrink("可乐");
    }
}
