package org.practice.thread.ch04cylicbarrier;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Java并发编程：CountDownLatch、CyclicBarrier和Semaphore
 * http://www.cnblogs.com/dolphin0520/p/3920397.html
 * 
 * @author Administrator
 *
 */
public class MyCountDownLatch {

	public static void main(String[] args) throws Exception {

		final CountDownLatch latch = new CountDownLatch(2);

		new Thread() {
			public void run() {
				try {
					System.out.println("This is First Thread Begin " + Thread.currentThread().getId() + " "
							+ Thread.currentThread().getName());
					Thread.sleep(4000);
					System.out.println("This is First Thread End");
					latch.countDown();
				} catch (Exception ex) {
					System.out.println("This is First Thread Exception");
				}
			}
		}.start();

		new Thread() {
			public void run() {
				try {
					System.out.println("This is Second Thread Begin " + Thread.currentThread().getId() + " "
							+ Thread.currentThread().getName());
					Thread.sleep(4000);
					System.out.println("This is Second Thread End");
					latch.countDown();
				} catch (Exception ex) {
					System.out.println("This is Second Thread Exception");
				}
			}
		}.start();

		System.out.println(
				"This is main Thread Begin " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
		// latch.await();
		latch.await(3, TimeUnit.MILLISECONDS);
		System.out.println(
				"This is main Thread End " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
	}

}
