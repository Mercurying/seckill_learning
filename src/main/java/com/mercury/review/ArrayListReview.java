package com.mercury.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/*java 基础知识复习之集合*/
public class ArrayListReview {

    /**
     * 1.ArrayList不是线程安全的 即多线程操作时不能保证同步 多线程使用 Vector 或者 CopyOnWriteArrayList
     * ArrayList 初始化调用的构造函数以及 扩容大小
     * 添加大量元素之前可以进行调用ensureCapacity方法减少递增式分配次数
     * 1.5倍
     * 常见知识复习：length --数组  length()--字符串 size()--集合
     * 位移运算符 <<(左移) >>(带符号右移) >>>(无符号右移)  右移一位相当于除以2 2的n次方
     *
     * @param args
     */
    public static void main(String[] args) {

//        int[] a = new int[3];
//        a[0] = 1;
//        a[1] = 2;
//        a[2] = 3;
//        int[] b = Arrays.copyOf(a, 10);
//        System.out.println("a.length:" + a.length + "\n" + "b.length:" + b.length);
//        for (int item : b) {
//            System.out.print(item + " ");
//        }
//        ArrayListReview.testEnsureCapacity();
        ArrayListReview.arrayListDemo();
    }


    private static void arrayListDemo() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        System.out.printf("Before add:arrayList.size()=%d\n", arrayList.size());
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(9);
        System.out.printf("After add:arrayList.size()=%d\n", arrayList.size());

        System.out.println("printing elements of arrayList");
        System.out.println("通过迭代器进行遍历:");
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println("通过ForEach进行遍历:");
        for (Integer item : arrayList) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("通过索引值进行遍历");
        for (int i = 0, len = arrayList.size(); i < len; i++) {
            System.out.print(arrayList.get(i) + " ");
        }

        // toArray方法
        Integer[] integers = arrayList.toArray(new Integer[0]);
        System.out.println("toArray integers:"+ Arrays.toString(integers));
        Integer[] integers1 = new Integer[arrayList.size()];
        arrayList.toArray(integers1);

        System.out.println();
        // 在指定位置添加元素
        arrayList.add(2, 2);
        // 在指定位置删除元素
        arrayList.remove(2);
        //  删除元素
        arrayList.remove((Object) 3);
        System.out.println("arrayList contains 5 is:" + arrayList.contains(5));
        // 清空集合
        arrayList.clear();
        System.out.println("arrayList is empty:" + arrayList.isEmpty());
    }


    // 测试ArrayList类中的扩容方法
    private static void testEnsureCapacity() {
        ArrayList<Object> list = new ArrayList<Object>();
        final int N = 10000000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法前:" + list.size());
        System.out.println("使用ensureCapacity方法前：" + (endTime - startTime));

        list = new ArrayList<Object>();
        long startTime1 = System.currentTimeMillis();
        list.ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法后:" + list.size());
        System.out.println("使用ensureCapacity方法后：" + (endTime1 - startTime1));
    }
}
