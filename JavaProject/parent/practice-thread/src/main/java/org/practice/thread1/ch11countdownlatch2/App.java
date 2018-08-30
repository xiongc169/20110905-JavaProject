package org.practice.thread1.ch11countdownlatch2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * Java并发编程：CountDownLatch、CyclicBarrier和Semaphore <br>
 * http://www.cnblogs.com/dolphin0520/p/3920397.html
 * 
 * @author Administrator
 *
 */
public class App {

	public static void main(String[] args) {
		semaphore();
	}

	public static void countDown() {
		CountDownLatch latch = new CountDownLatch(3);

		CountDownTask task = new CountDownTask(latch);
		CountDownTask task2 = new CountDownTask(latch);
		CountDownTask task3 = new CountDownTask(latch);

		Thread thread = new Thread(task);
		Thread thread2 = new Thread(task2);
		Thread thread3 = new Thread(task3);

		thread.start();
		thread2.start();
		thread3.start();

		try {
			System.out.printf("Main: %s Start \n", Thread.currentThread().getName());
			latch.await();
			System.out.printf("Main: %s End \n", Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void barrier() {
		CyclicBarrier barrier = new CyclicBarrier(2);

		CyclicBarrierTask task = new CyclicBarrierTask(barrier);
		CyclicBarrierTask task2 = new CyclicBarrierTask(barrier);
		CyclicBarrierTask task3 = new CyclicBarrierTask(barrier);

		Thread thread = new Thread(task);
		Thread thread2 = new Thread(task2);
		Thread thread3 = new Thread(task3);

		thread.start();
		thread2.start();
		thread3.start();

	}

	public static void semaphore() {
		Semaphore semaphore = new Semaphore(2);

		SemaphoreTask task = new SemaphoreTask(semaphore);
		SemaphoreTask task2 = new SemaphoreTask(semaphore);
		SemaphoreTask task3 = new SemaphoreTask(semaphore);

		Thread thread = new Thread(task);
		Thread thread2 = new Thread(task2);
		Thread thread3 = new Thread(task3);

		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int permits = semaphore.availablePermits();

		thread2.start();
		thread3.start();
	}
}
