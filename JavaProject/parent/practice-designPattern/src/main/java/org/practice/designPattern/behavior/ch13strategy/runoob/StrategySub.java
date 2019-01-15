package org.practice.designPattern.behavior.ch13strategy.runoob;

public class StrategySub implements Strategy {

    public void doOperation(double num1, double num2) {
        double result = num1 - num2;
        System.out.println("StrategySub's Result is: " + result);
    }

}
