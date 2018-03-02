package org.practice.designPattern.behavior.strategy;

public class StrategyAdd implements Strategy {

	public void doOperation(double num1, double num2) {
		// TODO Auto-generated method stub
		double result = num1 + num2;
		System.out.println("StrategyAdd's Result is: " + result);

	}

}
