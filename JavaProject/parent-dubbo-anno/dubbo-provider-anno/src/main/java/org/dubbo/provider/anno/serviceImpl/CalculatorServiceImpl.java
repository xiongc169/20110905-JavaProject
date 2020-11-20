package org.dubbo.provider.anno.serviceImpl;

import org.anno.common.facade.CalculatorService;

import com.alibaba.dubbo.config.annotation.Service;

@Service
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
