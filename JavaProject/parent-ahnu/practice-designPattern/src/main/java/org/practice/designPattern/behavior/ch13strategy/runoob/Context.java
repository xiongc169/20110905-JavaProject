package org.practice.designPattern.behavior.ch13strategy.runoob;

/**
 * @author yoong
 * <br>
 * @desc Context
 * <br>
 * @date 2019/1/15 11:35
 */
public class Context {

    private Strategy strategy;

    public Context() {
    }

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int num1, int num2) {
        strategy.doOperation(num1, num2);
    }
}
