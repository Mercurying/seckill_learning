package com.mercury.review.demo;

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
