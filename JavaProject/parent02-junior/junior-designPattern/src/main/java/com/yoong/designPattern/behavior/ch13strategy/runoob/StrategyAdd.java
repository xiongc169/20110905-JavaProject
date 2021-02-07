package com.yoong.designPattern.behavior.ch13strategy.runoob;

public class StrategyAdd implements Strategy {

    public void doOperation(double num1, double num2) {
        double result = num1 + num2;
        System.out.println("StrategyAdd's Result is: " + result);
    }

}
