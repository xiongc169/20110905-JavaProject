package org.dubbo.provider.serviceImpl;

import org.dubbo.service.CalculatorService;

public class AdvancedCalculatorServiceImpl implements CalculatorService {

    public double add(double a, double b) {
        double result = a + b;
        System.out.println("AdvancedCalculatorServiceImpl.add");
        return result * 10;
    }

    public double sub(double a, double b) {
        double result = a - b;
        System.out.println("AdvancedCalculatorServiceImpl.sub");
        return result * 10;
    }

    public double mul(double a, double b) {
        double result = a * b;
        System.out.println("AdvancedCalculatorServiceImpl.mul");
        return result * 10;
    }

    public double div(double a, double b) {
        double result = a / b;
        System.out.println("AdvancedCalculatorServiceImpl.div");
        return result * 10;
    }
}
