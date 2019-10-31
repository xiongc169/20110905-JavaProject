package org.dubbo.provider.serviceImpl;

import org.dubbo.service.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {

    public double add(double a, double b) {
        double result = a + b;
        System.out.println("CalculatorServiceImpl.add");
        return result;
    }

    public double sub(double a, double b) {
        double result = a - b;
        System.out.println("CalculatorServiceImpl.sub");
        return result;
    }

    public double mul(double a, double b) {
        double result = a * b;
        System.out.println("CalculatorServiceImpl.mul");
        return result;
    }

    public double div(double a, double b) {
        double result = a / b;
        System.out.println("CalculatorServiceImpl.div");
        return result;
    }
}
