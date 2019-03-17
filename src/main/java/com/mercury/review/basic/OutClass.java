package com.mercury.review.basic;


/**
 * 成员内部类测试
 * 说明：
 * 成员内部类中不能存在任何 static 的变量和方法;
 * 成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类.
 */
public class OutClass {
    private String str;

    public void outerDisplay() {
        System.out.println("outerClass...");
    }

    public class InnerClass {
        public void innerClassDisplay() {
            str = "innerClass display...";
            System.out.println(str);
            outerDisplay();
        }
    }

    public InnerClass getInstance() {
        return new InnerClass();
    }

    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        OutClass.InnerClass inner = outClass.getInstance();
        inner.innerClassDisplay();
    }

}
