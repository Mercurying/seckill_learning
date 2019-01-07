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
        int a = 10;
        Integer b = 10;
        Integer c = Integer.valueOf(10);
        Integer d = new Integer(10);
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(c == d);
        System.out.println(d == a);
    }
}
