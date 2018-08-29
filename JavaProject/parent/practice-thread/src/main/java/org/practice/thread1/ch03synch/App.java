package org.practice.thread1.ch03synch;

/**
 * @author yoong
 *
 * @desc App.java
 *
 * @date 2018年8月29日
 *
 */
public class App {

	/**
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		accountTest();
	}

	public static void accountTest() {
		InsertData output = new InsertData();

		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				output.insert(Thread.currentThread());
			}
		});

		Thread b = new Thread(new Runnable() {
			@Override
			public void run() {
				output.insert(Thread.currentThread());
			}
		});

		a.start();
		b.start();

	}

}
