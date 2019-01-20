package com.mercury.review.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionRun {

    public static void main(String[] args) {

        try {
            reflectConstructor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void reflectConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 获取 Teacher类
        Class clazz = Class.forName("com.mercury.review.reflection.Teacher");

        System.out.println("============获取所有公有构造函数===========");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("====所有的构造方法(包括私有、受保护的等)=======");
        constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("=========获取公有的无参的构造函数==========");

        Constructor con = clazz.getConstructor(null);
        System.out.println("con=" + con);

        Object obj = con.newInstance();

        System.out.println("=========获取私有的构造函数并调用=========");
        con = clazz.getDeclaredConstructor(Integer.class);
        System.out.println(con);
        con.setAccessible(true);
        obj = con.newInstance(100);

    }
}
