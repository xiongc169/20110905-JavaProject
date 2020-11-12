package com.yoong.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Desc AppLog4j2
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年11月22日
 * <p>
 * @Version 1.0
 */
public class AppLog4j2 {

    private static Logger rootLogger = LogManager.getRootLogger();

    private static Logger logger = LogManager.getLogger(AppLog4j2.class);

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        log4j2Demo();
        System.out.println("AppLog4j2 Ending");
    }

    public static void log4j2Demo() {
        //org.apache.logging.log4j.core.Logger
        System.out.println(rootLogger.getClass());
        rootLogger.debug("This is rootLogger.LOG4J2 DEBUG 2018-7-25 11:19:59");
        rootLogger.info("This is rootLogger.LOG4J2 INFO 2018-7-25 11:19:59");
        rootLogger.warn("This is rootLogger.LOG4J2 WARN 2018-7-25 11:19:59");
        rootLogger.error("This is rootLogger.LOG4J2 ERROR 2018-7-25 11:19:59");
        rootLogger.fatal("This is rootLogger.LOG4J2 FATAL 2018-7-25 11:19:59");
    }


}
