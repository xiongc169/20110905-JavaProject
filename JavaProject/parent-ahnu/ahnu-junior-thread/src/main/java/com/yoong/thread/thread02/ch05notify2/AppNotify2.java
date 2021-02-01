package com.yoong.thread.thread02.ch05notify2;

import java.util.ArrayList;

/**
 * @Desc Java并发编程：线程间协作的两种方式：wait、notify、notifyAll和Condition
 * http://www.cnblogs.com/dolphin0520/p/3920385.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月29日
 * <p>
 * @Version 1.0
 */
public class AppNotify2 {

	/**
	 * 入口函数
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
