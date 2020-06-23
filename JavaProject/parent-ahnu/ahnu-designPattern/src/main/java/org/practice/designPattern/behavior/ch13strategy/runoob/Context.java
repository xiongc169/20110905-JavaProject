package org.practice.designPattern.behavior.ch13strategy.runoob;

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
