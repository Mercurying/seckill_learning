package com.mercury.review.pattern.factory;

/**
 * 简单工厂模式
 * 工厂角色：核心
 * 抽象产品角色：简单工厂模式创建的所有对象的的父类 描述所有实例所具有的公共接口
 * 具体产品角色：简单工厂创建的目标
 */
public class ShapeSimpleFactory {

    public static Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();

        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;

    }
}
