package org.practice.designPattern.behavior.ch17responsibilityChain;

import org.practice.designPattern.behavior.ch17responsibilityChain.runoob.ConsoleLogger;
import org.practice.designPattern.behavior.ch17responsibilityChain.runoob.ErrorLogger;
import org.practice.designPattern.behavior.ch17responsibilityChain.runoob.FileLogger;
import org.practice.designPattern.behavior.ch17responsibilityChain.self.*;

/**
 * @Desc 责任链模式
 * http://www.runoob.com/design-pattern/chain-of-responsibility-pattern.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年7月4日
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            responsibleChain();
            selfDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void responsibleChain() {
        FileLogger file = new FileLogger(3, null);
        ErrorLogger error = new ErrorLogger(2, file);
        ConsoleLogger console = new ConsoleLogger(1, error);
        console.logger(5, "2019年1月15日14:40:54");
    }

    public static void selfDemo() {
        ALogger aLogger = new ALogger();
        BLogger bLogger = new BLogger();
        CLogger cLogger = new CLogger();
        DLogger dLogger = new DLogger();
        ELogger eLogger = new ELogger();

        aLogger.next = bLogger;
        bLogger.next = cLogger;
        cLogger.next = dLogger;
        dLogger.next = eLogger;

        aLogger.write();
    }
}
