package com.mercury.review.pattern.builder;

public class MealB extends MealBuilder {
    @Override
    public void builderFood() {
        meal.setDrink("柠檬果汁");
    }

    @Override
    public void builderDrink() {
        meal.setFood("手抓饼");
    }
}
