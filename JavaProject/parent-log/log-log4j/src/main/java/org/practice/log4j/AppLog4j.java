package org.practice.log4j;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * @Desc Log4j使用详解
 * PS：由Log4j(默认)、Servlet解析配置文件，代码中调用BasicConfigurator.configure()，PropertyConfigurator.configure解析配置文件；
 * https://blog.csdn.net/u011781521/article/details/55002553
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年11月22日
 * <p>
 * @Version 1.0
 */
public class AppLog4j {

    private static Logger rootLogger = Logger.getRootLogger();

    private static Logger logger = Logger.getLogger(AppLog4j.class);

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        //1、读取默认路径、默认配置文件名(log4j.properties)，用log4j默认的初始化过程解析并配置
        //2、读取非默认路径、非默认配置文件名，配置log4j环境——PropertyConfigurator
        //PropertyConfigurator.configure("\\Github\\20150712-JavaProject\\JavaProject\\parent-log\\log-log4j\\src\\main\\resources\\config\\log4j.xml");//D:\tmp\log4j.properties
        //PropertyConfigurator.configure("config/log4j.properties");
        //3、使用缺省log4j环境——BasicConfigurator
        //BasicConfigurator.configure();
        //4、代码中配置log4j环境——init()
        //init();
        rootLoggerDemo();
        loggerDemo();
        System.out.println("LOG4J Ending");
    }

    public static void rootLoggerDemo() {
        //org.apache.log4j.spi.RootLogger
        System.out.println(rootLogger.getClass());
        rootLogger.debug("This is rootLogger.LOG4J DEBUG 2018-7-25 11:19:59");
        rootLogger.info("This is rootLogger.LOG4J INFO 2018-7-25 11:19:59");
        rootLogger.warn("This is rootLogger.LOG4J WARN 2018-7-25 11:19:59");
        rootLogger.error("This is rootLogger.LOG4J ERROR 2018-7-25 11:19:59");
        rootLogger.fatal("This is rootLogger.LOG4J FATAL 2018-7-25 11:19:59");
    }

    public static void loggerDemo() {
        //org.apache.log4j.Logger
        System.out.println(logger.getClass());
        logger.debug("This is LOG4J DEBUG 2018-7-25 11:19:59");
        logger.info("This is LOG4J INFO 2018-7-25 11:19:59");
        logger.warn("This is LOG4J WARN 2018-7-25 11:19:59");
        logger.error("This is LOG4J ERROR 2018-7-25 11:19:59");
        logger.fatal("This is LOG4J FATAL 2018-7-25 11:19:59");
    }

    private static void init() {
        PatternLayout p = new PatternLayout("%-4r[%t]%-5p%c%x-%m%n");
        ConsoleAppender a = new ConsoleAppender(p, ConsoleAppender.SYSTEM_OUT);
        rootLogger.addAppender(a);
        rootLogger.setLevel(Level.ALL);
    }
}
