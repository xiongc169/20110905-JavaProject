package org.practice.thread1.ch11countdownlatch2;

import java.util.concurrent.CountDownLatch;

public class CountDownTask implements Runnable {

	private CountDownLatch latch;

	public CountDownTask(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		System.out.printf("%s Start \n", Thread.currentThread().getName());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		latch.countDown();
		System.out.printf("%s End \n", Thread.currentThread().getName());

	}

}
