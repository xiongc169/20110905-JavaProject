package org.practice.java8.para.para02Interface;

public interface IGreet {

	default void defaultMethod() {
		System.out.println("Hello,This is default Method");
	}

	static void staticMethod() {
		System.out.println("Hello,This is static Method");
	}

	void myMethod();

}
