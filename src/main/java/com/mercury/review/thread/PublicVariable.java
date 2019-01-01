package com.mercury.review.thread;

public class PublicVariable {

    private String userName = "name";
    private String password = "password";

    // 暂时并未添加synchronized关键字进行同步代码块
    public synchronized void getValue() {
        System.out.println("getValue method thread name:" + Thread.currentThread().getName() + " " +
                "username=" + userName + " " + "password=" + password);
    }

    // 写操作添加synchronized关键字 确保线程安全
    public synchronized void setValue(String name, String password) {
        try {
            this.userName = name;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("setValue method thread name:" + Thread.currentThread().getName() + " " +
                    "userName=" + userName + " " + "password=" + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
