package org.practice.thread.ch09signal;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
