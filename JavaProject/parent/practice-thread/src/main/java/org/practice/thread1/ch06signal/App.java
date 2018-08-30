package org.practice.thread1.ch06signal;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
