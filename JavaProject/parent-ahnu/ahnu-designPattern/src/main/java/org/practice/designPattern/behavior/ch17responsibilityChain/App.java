package org.practice.designPattern.behavior.ch17responsibilityChain;

import org.practice.designPattern.behavior.ch17responsibilityChain.runoob.ConsoleLogger;
import org.practice.designPattern.behavior.ch17responsibilityChain.runoob.ErrorLogger;
import org.practice.designPattern.behavior.ch17responsibilityChain.runoob.FileLogger;

/**
 * 责任链模式
 * http://www.runoob.com/design-pattern/chain-of-responsibility-pattern.html
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            responsibleChain();
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
}
