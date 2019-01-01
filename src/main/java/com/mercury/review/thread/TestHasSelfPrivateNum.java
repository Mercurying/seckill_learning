package com.mercury.review.thread;

public class TestHasSelfPrivateNum {
    public static void main(String[] args) {
        // 不同对象访问不同锁
        HasSelfPrivateNum aNum = new HasSelfPrivateNum();
        HasSelfPrivateNum bNum = new HasSelfPrivateNum();
        ThreadA a = new ThreadA(aNum);
        a.start();
        ThreadB b = new ThreadB(bNum);
        b.start();
    }
}
