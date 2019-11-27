package com.yoong.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * App4Jcl
 */
public class App4Jcl {

    private static Log log = LogFactory.getLog(App4Jcl.class);

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        jclDemo();
        System.out.println("App4Jcl Ending");
    }

    public static void jclDemo() {
        //不添加log4j依赖，类型为：org.apache.commons.logging.impl.Jdk14Logger
        //添加log4j依赖，类型为：org.apache.commons.logging.impl.Log4JLogger
        System.out.println(log.getClass());
        log.trace("App4Jcl.trace");
        log.debug("App4Jcl.debug");
        log.info("App4Jcl.info");
        log.warn("App4Jcl.warn");
        log.error("App4Jcl.derrorebug");
        log.fatal("App4Jcl.fatal");
    }
}
