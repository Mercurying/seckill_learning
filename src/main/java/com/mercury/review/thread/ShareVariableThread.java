package com.mercury.review.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*多线程之间共享变量线程不安全
 * 线程不安全是由于实例变量导致 如果是方法内的私有变量 则不存在"非线程安全问题"
 * */
public class ShareVariableThread extends Thread {

    private int count = 5;
    public static final Logger LOGGER = LoggerFactory.getLogger(ShareVariableThread.class);

    public ShareVariableThread(String name) {
        super();
        this.setName(name);
    }

    public void run() {
        super.run();
        count--;
        LOGGER.info("由{}计算,count={}", ShareVariableThread.currentThread().getName(), count);
    }

}
