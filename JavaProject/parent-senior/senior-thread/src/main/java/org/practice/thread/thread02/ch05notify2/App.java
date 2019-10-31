package org.practice.thread.thread02.ch05notify2;

import java.util.ArrayList;

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

	/**
	 * 入口函数
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		Object obj = new Object();
		ArrayList<String> list = new ArrayList<String>();

		Consumer consumer = new Consumer(obj, list);
		Thread conThread = new Thread(consumer);

		Producer producer = new Producer(obj, list);
		Thread proThread = new Thread(producer);

		conThread.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		proThread.start();

	}

}
