package com.mercury.review.pattern.facadepattern.children;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CPU {
    public static final Logger logger = LoggerFactory.getLogger(CPU.class);

    public void start() {
        logger.info("CPU starts ...");
    }

    public void shutDown() {
        logger.info("CPU shutDown...");
    }

}
