package org.practice.designPattern.behavior.strategy;

public class App {

	public static void main(String[] args) {

		double num1 = 100;
		double num2 = 200;

		context(new StrategyAdd(), num1, num2);
		context(new StrategySub(), num1, num2);
		context(new StrategyMul(), num1, num2);
		context(new StrategyDiv(), num1, num2);
	}

	public static void context(Strategy strategy, double num1, double num2) {

		strategy.doOperation(num1, num2);

	}

}
