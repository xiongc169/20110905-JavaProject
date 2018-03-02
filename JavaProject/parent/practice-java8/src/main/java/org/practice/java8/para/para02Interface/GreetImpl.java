package org.practice.java8.para.para02Interface;

public class GreetImpl implements IGreet {

	@Override
	public void myMethod() {

		System.out.println("Hello,This is myMethod");

	}

	public void defaultMethod() {

		System.out.println("Hello,This is GreetImpl.defaultMethod");

	}

	public static void staticMethod() {

		System.out.println("Hello,This is GreetImpl.staticMethod");

	}

}
