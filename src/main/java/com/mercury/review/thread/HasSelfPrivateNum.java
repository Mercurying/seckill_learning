package com.mercury.review.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HasSelfPrivateNum {
    public static final Logger LOGGER = LoggerFactory.getLogger(HasSelfPrivateNum.class);
    private int num = 0;

    // 注意此处添加了synchronized关键字
    public synchronized void addNum(String name) {
        try {
            if (name.equals("a")) {
                num = 100;
                LOGGER.info("a:set num finished");
                // 构造异步执行效果 线程睡眠5秒
                Thread.sleep(5000);
            } else {
                num = 200;
                LOGGER.info("b:set num finished");
            }
            LOGGER.info("{} set num={}", name, num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
