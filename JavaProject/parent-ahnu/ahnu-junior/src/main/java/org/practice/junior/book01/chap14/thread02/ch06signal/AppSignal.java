package org.practice.junior.book01.chap14.thread02.ch06signal;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
public class AppSignal {

	/**
	 * 入口函数
	 */
	public static void main(String[] args) {

		Lock lock = new ReentrantLock();
		Condition conCondition = lock.newCondition();
		Condition proCondition = lock.newCondition();

		ArrayList<String> list = new ArrayList<String>();

		Consumer consumer = new Consumer(lock, conCondition, proCondition, list);
		Thread conThread = new Thread(consumer);

		Producer producer = new Producer(lock, conCondition, proCondition, list);
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
