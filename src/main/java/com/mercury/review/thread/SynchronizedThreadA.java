package com.mercury.review.thread;

public class SynchronizedThreadA extends Thread {
    PublicVariable publicVarRef;

    public SynchronizedThreadA(PublicVariable publicVarRef) {
        super();
        this.publicVarRef = publicVarRef;
    }

    public void run() {
        super.run();
        publicVarRef.setValue("java", "java2019");
    }


    // 测试synchronized关键字影响

    /**
     * 未添加synchronized关键字
     * getValue method thread name:main username=java password=password
     * setValue method thread name:Thread-0 userName=java password=java2019
     * 添加synchronized关键字之后
     * setValue method thread name:Thread-0 userName=java password=java2019
     * getValue method thread name:main username=java password=java2019
     */
    public static void main(String[] args) {
        try {
            PublicVariable publicVariable = new PublicVariable();
            SynchronizedThreadA thread = new SynchronizedThreadA(publicVariable);
            thread.start();
            Thread.sleep(200);
            publicVariable.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
