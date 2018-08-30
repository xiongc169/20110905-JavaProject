package org.practice.thread1.ch03synch;

/**
 * @author yoong
 *
 * @desc Java并发编程：synchronized <br>
 *       http://www.cnblogs.com/dolphin0520/p/3923737.html <br>
 *       Java并发编程：Lock <br>
 *       http://www.cnblogs.com/dolphin0520/p/3923167.html
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
		outputTest();
	}

	public static void outputTest() {
		InsertData output = new InsertData();

		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				output.insert4Lock(Thread.currentThread());
			}
		});

		Thread b = new Thread(new Runnable() {
			@Override
			public void run() {
				output.insert4Lock(Thread.currentThread());
			}
		});

		a.start();
		b.start();

	}
}
