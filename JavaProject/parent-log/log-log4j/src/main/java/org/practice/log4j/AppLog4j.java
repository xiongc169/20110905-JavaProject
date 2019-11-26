package org.practice.log4j;

import org.apache.log4j.Logger;

/**
 * AppLog4j
 */
public class AppLog4j {

    private static Logger rootLogger = Logger.getRootLogger();

    private static Logger logger = Logger.getLogger(AppLog4j.class);

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        rootLoggerDemo();
        loggerDemo();
        System.out.println("LOG4J Ending");
    }

    public static void rootLoggerDemo() {
        rootLogger.debug("This is rootLogger.LOG4J DEBUG 2018-7-25 11:19:59");
        rootLogger.info("This is rootLogger.LOG4J INFO 2018-7-25 11:19:59");
        rootLogger.warn("This is rootLogger.LOG4J WARN 2018-7-25 11:19:59");
        rootLogger.error("This is rootLogger.LOG4J ERROR 2018-7-25 11:19:59");
        rootLogger.fatal("This is rootLogger.LOG4J FATAL 2018-7-25 11:19:59");
    }

    public static void loggerDemo() {
        logger.debug("This is LOG4J DEBUG 2018-7-25 11:19:59");
        logger.info("This is LOG4J INFO 2018-7-25 11:19:59");
        logger.warn("This is LOG4J WARN 2018-7-25 11:19:59");
        logger.error("This is LOG4J ERROR 2018-7-25 11:19:59");
        logger.fatal("This is LOG4J FATAL 2018-7-25 11:19:59");
    }
}
