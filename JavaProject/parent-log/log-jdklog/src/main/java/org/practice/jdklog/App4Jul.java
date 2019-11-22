package org.practice.jdklog;

import java.util.logging.*;

/**
 * App4Jul
 */
public class App4Jul {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            output();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void output() {
        //Logger logger = new Logger();
        Logger logger2 = Logger.getLogger("name");
        logger2.info("app4Jul.output");
        logger2.info("app4Jul.output");
        logger2.info("app4Jul.output");
        logger2.info("app4Jul.output");
    }
}
