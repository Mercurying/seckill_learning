package com.mercury.review.pattern.factory;

public class ShapeSimpleFactoryReflection {
    // 通过反射机制调用对应的类 对简单工厂类进行扩展
    public static Object getClass(Class<? extends Shape> clazz) {
        Object obj = null;
        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
