package org.practice.designPattern.behavior.ch13strategy;

import org.practice.designPattern.behavior.ch13strategy.runoob.*;

/**
 * 策略模式
 * http://www.runoob.com/design-pattern/strategy-pattern.html
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            runoobTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void runoobTest() {
        Integer num1 = 100;
        Integer num2 = 200;

        Context add = new Context(new StrategyAdd());
        Context sub = new Context(new StrategySub());
        Context mul = new Context(new StrategyMul());
        Context div = new Context(new StrategyDiv());

        add.executeStrategy(num1, num2);
        sub.executeStrategy(num1, num2);
        mul.executeStrategy(num1, num2);
        div.executeStrategy(num1, num2);
    }
}
