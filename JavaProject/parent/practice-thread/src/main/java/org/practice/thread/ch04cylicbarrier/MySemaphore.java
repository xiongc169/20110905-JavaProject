package org.practice.thread.ch04cylicbarrier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 * Java并发编程：CountDownLatch、CyclicBarrier和Semaphore
 * http://www.cnblogs.com/dolphin0520/p/3920397.html
 * 
 * @author Administrator
 *
 */
public class MySemaphore {

	public static void main(String[] args) {

		Semaphore semaphore = new Semaphore(3);
		for (int i = 0; i < 9; i++) {
			MyThread myThread = new MyThread(i, semaphore);
			myThread.start();
		}

		System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName());
	}

}

class MyThread extends Thread {

	private int num;

	private Semaphore semaphore;

	private DateFormat dt = new SimpleDateFormat("yyyyMMddHHmmss");

	public MyThread() {
	}

	public MyThread(int num, Semaphore se) {
		this.num = num;
		this.semaphore = se;
	}

	public void run() {
		try {
			semaphore.acquire();
			System.out.println(dt.format(new Date()) + " " + num + " Begin, " + Thread.currentThread().getId());
			Thread.sleep(4000);
			System.out.println(dt.format(new Date()) + " " + num + " End, " + Thread.currentThread().getId());
			semaphore.release();
		} catch (InterruptedException e) {
			String msg = e.getMessage();
			System.out.println(msg);
		}
	}

}
