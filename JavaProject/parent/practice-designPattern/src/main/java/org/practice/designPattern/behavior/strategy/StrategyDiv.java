package org.practice.designPattern.behavior.strategy;

public class StrategyDiv implements Strategy {

	public void doOperation(double num1, double num2) {

		double result = num1 / num2;
		System.out.println("StrategyDiv's Result is: " + result);

	}

}
