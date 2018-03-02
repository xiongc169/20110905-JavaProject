package org.practice.primary.proxy;

/**
 * @description Calculator.java
 * @author chaoxiong
 * @date 2016年8月13日 下午2:26:34
 */
public class Calculator {

	public void add(int i, int j) {
		int result = i + j;
		System.out.println("add result is " + result);
	}

	public void sub(int i, int j) {
		int result = i - j;
		System.out.println("sub result is " + result);
	}

	public void mul(int i, int j) {
		int result = i * j;
		System.out.println("mul result is " + result);
	}

	public void div(int i, int j) {
		int result = i / j;
		System.out.println("div result is " + result);
	}
}
