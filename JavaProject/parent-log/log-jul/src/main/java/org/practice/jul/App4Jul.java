package org.practice.jul;

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
        logger2.setLevel(Level.FINEST);
        //logger2.server("server: app4Jul.output");
        logger2.warning("warning: app4Jul.output");
        logger2.info("info: app4Jul.output");
        logger2.config("config: app4Jul.output");
        logger2.fine("fine: app4Jul.output");
        logger2.finer("finer: app4Jul.output");
        logger2.finest("finest: app4Jul.output");
    }
}
