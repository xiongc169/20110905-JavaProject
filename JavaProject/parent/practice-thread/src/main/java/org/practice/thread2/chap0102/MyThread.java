package org.practice.thread2.chap0102;

public class MyThread extends Thread {

	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println("Current ThreadName :" + name);
	}

}
