package com.mercury.review.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Base {
    private static final Logger logger = LoggerFactory.getLogger(Base.class);

    // 1.父类静态代码块
    static {
        logger.info("Base static block!");
    }

    // 3.父类非静态代码块
    {
        logger.info("Base block!");
    }

    // 4.父类构造器
    public Base() {
        logger.info("Base constructor!");
    }

}

public class Derived extends Base {
    private static final Logger logger = LoggerFactory.getLogger(Derived.class);

    static {
        logger.info("Derived static blocks!");
    }

    {
        logger.info("Derived blocks");
    }

    public Derived() {
        logger.info("Derived constructor!");
    }

    public static void main(String[] args) {
        new Derived();
    }

}
