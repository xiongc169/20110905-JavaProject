package org.practice.thread1.ch11countdownlatch2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTask implements Runnable {

	private CyclicBarrier barrier;

	public CyclicBarrierTask(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	public void run() {
		System.out.printf("%s Start \n", Thread.currentThread().getName());

		try {
			Thread.sleep(3000);
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}

		System.out.printf("%s End \n", Thread.currentThread().getName());
	}
}
