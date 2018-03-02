package org.practice.thread.ch01primary;

import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {

	public int count = 10;

	private ReentrantLock lock = new ReentrantLock();

	public MyThread() {
	}

	public MyThread(Runnable runnable) {
		super(runnable);
	}

	public synchronized void run() {
		lock.lock();
		try {
			count--;
			long threadId = Thread.currentThread().getId();
			String threadName = Thread.currentThread().getName();
			System.out.println("threadId: " + threadId + "; count: " + count);
			
		} finally {
			lock.unlock();
		}
	}

}
