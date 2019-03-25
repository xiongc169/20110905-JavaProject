package org.practice.thread2.chap0104;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class App {

	/**
	 * 入口函数
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		PrimeTask primeTask = new PrimeTask(1);
		Thread primeThread = new Thread(primeTask);
		primeThread.start();
		try {
			Thread.sleep(2000);
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		primeThread.interrupt();
		System.out.println("Main Ending");
	}

}
