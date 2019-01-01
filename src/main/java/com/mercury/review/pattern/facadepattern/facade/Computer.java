package com.mercury.review.pattern.facadepattern.facade;

import com.mercury.review.pattern.facadepattern.children.CPU;
import com.mercury.review.pattern.facadepattern.children.Disk;
import com.mercury.review.pattern.facadepattern.children.Memory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*门面模式核心类*/
public class Computer {
    public static final Logger logger = LoggerFactory.getLogger(Computer.class);
    private CPU cpu;
    private Memory memory;
    private Disk disk;


    public Computer() {
        cpu = new CPU();
        disk = new Disk();
        memory = new Memory();
    }

    public void start() {
        logger.info("Computer start...");
        cpu.start();
        memory.start();
        disk.start();
        logger.info("Computer start end...");
    }

    public void shutDown() {
        logger.info("Computer shutDown...");
        cpu.shutDown();
        memory.shutDown();
        disk.shutDown();
        logger.info("Computer shutDown end...");
    }
}
