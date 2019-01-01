package com.mercury.review.pattern.dynamic;


/**
 * 测试cglib实现代理
 */
public class TestCGLIB {
    public static void main(String[] args) {
        BookProxyLib cglib = new BookProxyLib();
        BookProxyImpl bookCglib = (BookProxyImpl) cglib.getInstance(new BookProxyImpl());
        bookCglib.addBook();
    }
}
