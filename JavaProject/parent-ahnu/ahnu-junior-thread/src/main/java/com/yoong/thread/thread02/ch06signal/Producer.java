package com.yoong.thread.thread02.ch06signal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {

	private Lock lock;

	private Condition conCondition;

	private Condition proCondition;

	private List<String> list = new ArrayList<String>();

	public Producer(Lock lock, Condition conCondition, Condition proCondition, ArrayList<String> list) {
		this.lock = lock;
		this.conCondition = conCondition;
		this.proCondition = proCondition;

		this.list = list;
	}

	public void run() {
		while (true) {
			lock.lock();
			if (list.size() >= 10) {
				System.out.println("生产者：集合已满，生产者阻塞！");
				try {
					proCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
					proCondition.signal();
				}
			}
			String tmp = "集合元素：" + Math.random();
			list.add(tmp);
			System.out.println("生产者：添加集合元素：" + tmp);
			conCondition.signal();
			lock.unlock();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
