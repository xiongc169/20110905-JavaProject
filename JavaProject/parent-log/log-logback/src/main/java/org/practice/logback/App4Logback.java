package org.practice.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Desc App4Logback
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年11月22日
 * <p>
 * @Version 1.0
 */
public class App4Logback {

    private static Logger LOGGER = LoggerFactory.getLogger(App4Logback.class);

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        logbackDemo();
        System.out.println("logback Ending");
    }

    public static void logbackDemo() {
        LOGGER.debug("logback的--debug日志--输出");
        LOGGER.info("logback的--info日志--输出");
        LOGGER.warn("logback的--warn日志--输出");
        LOGGER.error("logback的--error日志--输出");
    }
}
