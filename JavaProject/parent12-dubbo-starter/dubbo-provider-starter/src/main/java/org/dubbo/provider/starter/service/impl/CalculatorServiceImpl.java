package org.dubbo.provider.starter.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.dubbo.common.starter.facade.CalculatorService;

@DubboService
public class CalculatorServiceImpl implements CalculatorService {

    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        return a / b;
    }

}
