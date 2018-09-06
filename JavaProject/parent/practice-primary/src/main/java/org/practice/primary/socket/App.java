package org.practice.primary.socket;

/**
 * Hello world!
 *
 */
public class App {

	/**
	 * 入口函数
	 * 
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		System.out.println("Test Starting!");

		netTest();

		System.out.println("Test Ending!");
	}

	public static void netTest() {
		ClientPoint clientPoint = new ClientPoint();
		clientPoint.primaryTest();
	}
}
