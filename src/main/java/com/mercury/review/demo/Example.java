package com.mercury.review.demo;

/**
 * 说明测试：基本类型与包装类型之间的装箱与拆箱操作转换
 * 基本类型 Byte Character Integer Short Long Double Float Boolean
 * 装箱：基本类型-->包装类型
 * 拆箱：包装类型-->基本类型
 * 当包装类型与基本类型进行数值比较时 默然将包装类型进行拆箱操作 转换成对应的基本类型在进行比较
 * 例如： Integer --> int  intValue()  装箱方法是 valueOf()
 * 两个包装类型进行比较时 当范围在-128~127之间时 会直接从IntegerCache中取出对应的引用
 *
 * @author mercury
 * @date 2019/1/6 18:53
 */
public class Example {
    public static void main(String[] args) {
        // testTwo();
        // testString();
        testImmutableString();
    }

    public static void testOne() {
        int a = 10;
        Integer b = 10;
        Integer c = Integer.valueOf(10);
        Integer d = new Integer(10);
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(c == d);
        System.out.println(d == a);
        System.out.println(c.equals(d));
    }

    public static void testTwo() {
        Integer a = 10;
        Integer b = 10;
        Integer c = 130;
        Integer d = 130;
        Integer e = new Integer(10);
        Integer f = new Integer(130);
        Integer g = new Integer(10);
        Integer h = new Integer(100);
        Integer i = new Integer(30);
        System.out.println("a==b," + (a == b));
        System.out.println("c==d," + (c == d));
        System.out.println("a==e," + (a == e));
        System.out.println("c==f," + (c == f));
        System.out.println("e==g," + (e == g));
        // true 由于+不适合于Integer对象因此首先对h,i进行拆箱操作 f==130 f为Integer对象自动进行拆箱操作
        System.out.println("f=e+i," + (f == h + i));
    }

    public static void testString() {
        String a = "name";
        String b = "name";
        String c = new String("name");
        String d = a.intern();
        String e = "spring" + "-data";
        String f = "spring";
        String g = "-data";
        String i = "spring-data";
        String h = f + g;
        System.out.println("d= " + d);
        System.out.println("e==h," + (e == h));
        System.out.println("e==i," + (e == i));
        System.out.println("a==b," + (a == b));
        System.out.println("a.equals(b)," + (a.equals(b)));
        System.out.println("a==c," + (a == c));
        System.out.println("a.equals(c)," + (a.equals(c)));

    }

    public static void testImmutableString() {
        String flag = "hello";       // 在字符串常量池上创建字符串
        flag = flag + "world";       // 通过new方式在堆上创建对象
        String word = "hello world"; // 在字符串常量池中创建对象
        System.out.println("flag=" + flag);
        System.out.println("flag==word," + (flag == word));
    }
}
