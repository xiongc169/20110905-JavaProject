package org.practice.thread.ch02primary;

/**
 * 
 * @author chaoxiong
 * @since 2015-10-19 15:45:45
 */
public class MyRunnable implements Runnable {

	private int flag = 10;

	public void run() {
		// synchronized (this) {
		// for (int i = 0; i < 10; i++) {
		flag = flag - 1;
		String output = String.format("runnable %s  %d", Thread.currentThread().getName(), flag);
		System.out.println(output);
		// }
		// }
	}

}
