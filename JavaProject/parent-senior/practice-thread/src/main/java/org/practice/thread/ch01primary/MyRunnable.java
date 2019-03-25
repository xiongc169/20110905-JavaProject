package org.practice.thread.ch01primary;

public class MyRunnable implements Runnable {

	public void run() {

		long threadId = Thread.currentThread().getId();
		String threadName = Thread.currentThread().getName();
		System.out.println("Runnable threadId: " + threadId + "; Runnable threadName: " + threadName);

	}

}
