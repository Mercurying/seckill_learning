package com.mercury.review.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试多线程情形下变量不共享
 */
public class MyThread extends Thread {

    private int count = 5;

    public static final Logger logger = LoggerFactory.getLogger(MyThread.class);

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    public void run() {
        super.run();
        while (count > 0) {
            count--;
            logger.info("由{}计算,count={}", MyThread.currentThread().getName(), count);
        }
    }
}
