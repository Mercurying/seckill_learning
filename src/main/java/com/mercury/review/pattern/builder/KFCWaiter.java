package com.mercury.review.pattern.builder;

// 指挥者 主要用于构造复杂对象时,它主要有两个作用：
// 一是：隔离客户与对象的生产过程
// 二是：负责控制产品对象的生产过程
public class KFCWaiter {
    private MealBuilder mealBuilder;

    public KFCWaiter(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal construct() {
        // 准备食物
        mealBuilder.builderFood();
        // 准备饮料
        mealBuilder.builderDrink();
        // 完成之后 返回一个完整的的套餐给客户
        return mealBuilder.getMeal();
    }
}
