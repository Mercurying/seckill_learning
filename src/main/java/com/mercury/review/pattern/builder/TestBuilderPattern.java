package com.mercury.review.pattern.builder;


/**
 * 建造者模式：生成器模式 对象构造模式 可以将复杂对象构造过程抽象出来 使这个抽象过程的不同实现方法可以
 * 构造出不同的表现的对象
 * 建造者模式就是一步一步创建一个复杂的对象
 * 组装零部件 组装成一个复杂的新产品
 */
public class TestBuilderPattern {
    public static void main(String[] args) {
        MealA a = new MealA();
        KFCWaiter waiter = new KFCWaiter(a);
        Meal mealA = waiter.construct();
        System.out.print("***套餐A的组成部分***");
        System.out.println("食物:" + mealA.getFood() + " " + "饮料:" + mealA.getDrink());
    }
}
