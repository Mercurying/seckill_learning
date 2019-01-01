package com.mercury.review.pattern.prototype;


/**
 * 原型模式：
 * 当创建对象的实例比较复杂时 使用原型模式可以简化对象的创建过程,通过一个已有的实例可以提高新实例
 * 的创建效率
 * 可以动态增加或减少产品类
 * 原型模式提供了简化的创建结构
 * 可以使用深克隆的方式保存对象的状态
 */
public class TestPrototype {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen underlinePen = new UnderlinePen('~');
        MessageBox mBox = new MessageBox('*');
        MessageBox sBox = new MessageBox('/');
        manager.register("Strong message", underlinePen);
        manager.register("Waring Box", mBox);
        manager.register("Slash Box", sBox);
        Product p1 = manager.create("Strong message");
        p1.use("hello world");
        Product p2 = manager.create("Waring Box");
        p2.use("hello world");
        Product p3 = manager.create("Slash Box");
        p3.use("hello world");
    }
}
