package org.dubbo.provider.serviceImpl;

import org.dubbo.common.service.CalculatorService;

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
