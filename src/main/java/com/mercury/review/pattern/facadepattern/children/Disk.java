package com.mercury.review.pattern.facadepattern.children;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Disk {
    public static final Logger logger = LoggerFactory.getLogger(Disk.class);

    public void start() {
        logger.info("Disk start...");
    }

    public void shutDown() {
        logger.info("Disk shutDown...");
    }
}
