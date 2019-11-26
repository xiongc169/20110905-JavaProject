package org.practice.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AppSlf4j
 */
public class AppSlf4j {

    private static Logger log = LoggerFactory.getLogger(AppSlf4j.class);

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        slf4jDemo();
        System.out.println("SLF4J Ending");
    }

    public static void slf4jDemo() {
        log.debug("This is SLF4J DEBUG 2018-7-25 11:19:59");
        log.info("This is SLF4J INFO 2018-7-25 11:20:10");
        log.warn("This is SLF4J WARN 2018-7-25 11:20:16");
        log.error("This is SLF4J ERROR 2018-7-25 11:20:21");
    }
}
