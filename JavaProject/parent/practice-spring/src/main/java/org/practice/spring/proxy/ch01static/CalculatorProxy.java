package org.practice.spring.proxy.ch01static;

import org.practice.spring.proxy.api.ICalculator;

/**
 * @description CalculatorProxy
 * @author yoong
 * @date 2016年8月13日 下午2:26:34
 */
public class CalculatorProxy implements ICalculator {

	/**
	 * 被代理的对象
	 */
	ICalculator calculator = new CalculatorImpl();

	public int add(int i, int j) {
		int result = calculator.add(i, j);
		System.out.println("CalculatorProxy.add result is " + result);
		return result;
	}

	public int sub(int i, int j) {
		int result = calculator.sub(i, j);
		System.out.println("CalculatorProxy.sub result is " + result);
		return result;
	}

	public int mul(int i, int j) {
		int result = calculator.mul(i, j);
		System.out.println("CalculatorProxy.mul result is " + result);
		return result;
	}

	public double div(int i, int j) {
		double result = calculator.div(i, j);
		System.out.println("CalculatorProxy.div result is " + result);
		return result;
	}
}
