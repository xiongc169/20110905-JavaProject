package org.practice.designPattern.behavior.ch13strategy;

import org.practice.designPattern.behavior.ch13strategy.runoob.*;

/**
 * @Desc 策略模式
 * http://www.runoob.com/design-pattern/strategy-pattern.html
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
            strategy_runoob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void strategy_runoob() {
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
