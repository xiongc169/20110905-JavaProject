package com.yoong.designPattern.behavior.ch13strategy.runoob;

public class StrategyMul implements Strategy {

    public void doOperation(double num1, double num2) {
        double result = num1 * num2;
        System.out.println("StrategyMul's Result is: " + result);
    }

}
