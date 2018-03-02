package org.practice.thread2.chap0102;

public class App {

	public static void main(String[] args) {
		
		MyThread thread=new MyThread();
		Boolean isInter = thread.interrupted();

	}

	public static void RunnableTest() {
		//
		for (int i = 0; i < 10; i++) {
			Calculator calculator = new Calculator(i);
			Thread thread = new Thread(calculator);
			thread.start();
		}
	}

}
