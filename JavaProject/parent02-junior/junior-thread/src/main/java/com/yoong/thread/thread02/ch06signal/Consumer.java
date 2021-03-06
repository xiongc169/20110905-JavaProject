package com.yoong.thread.thread02.ch06signal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {

	private Lock lock;

	private Condition conCondition;

	private Condition proCondition;

	private List<String> list = new ArrayList<String>();

	public Consumer(Lock lock, Condition conCondition, Condition proCondition, ArrayList<String> list) {
		this.lock = lock;
		this.conCondition = conCondition;
		this.proCondition = proCondition;

		this.list = list;
	}

	public void run() {
		while (true) {
			lock.lock();
			try {

				if (list.size() <= 0) {
					System.out.println("消费者：集合为空，消费者阻塞！");
					try {
						conCondition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
						conCondition.signal();
					}
				}
				String tmp = list.get(0);
				list.remove(0);
				System.out.println("消费者：取集合元素：" + tmp);
				proCondition.signal();
			} finally {
				lock.unlock();
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
