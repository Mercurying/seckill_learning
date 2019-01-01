package com.mercury.review.pattern.facadepattern.children;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Memory {

    public static final Logger logger = LoggerFactory.getLogger(Memory.class);

    public void start() {
        logger.info("Memory start...");
    }

    public void shutDown() {
        logger.info("Memory shutDown...");
    }
}
