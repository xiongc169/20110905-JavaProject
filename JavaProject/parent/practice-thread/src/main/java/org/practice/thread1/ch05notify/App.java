package org.practice.thread1.ch05notify;

/**
 * @author Java并发编程：线程间协作的两种方式：wait、notify、notifyAll和Condition <br>
 *         http://www.cnblogs.com/dolphin0520/p/3920385.html
 *
 * @desc App.java
 *
 * @date 2018年8月30日
 *
 */
public class App {

	public static void main(String[] args) {

		Object obj = new Object();

		WaitTask wait = new WaitTask(obj);
		Thread waitThread = new Thread(wait);
		waitThread.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		NotifyTask notify = new NotifyTask(obj);
		Thread notifyThread = new Thread(notify);
		notifyThread.start();

	}

}
