package org.practice.thread2.chap0102;

public class App {

	public static void main(String[] args) {

		calculatorTest();

		MyThread thread = new MyThread();
		thread.start();

		// Boolean isInter = thread.interrupted();

	}

	public static void calculatorTest() {

		for (int i = 0; i < 10; i++) {
			Calculator calculator = new Calculator(i);
			Thread thread = new Thread(calculator);
			thread.start();
		}
	}

}
