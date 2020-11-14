package org.practice.primary.book01.chap14.thread02.ch05notify2;

import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable {

	private Object obj;

	private List<String> list = new ArrayList<String>();

	public Consumer(Object obj, ArrayList<String> list) {
		this.obj = obj;
		this.list = list;
	}

	public void run() {
		while (true) {
			synchronized (obj) {
				if (list.size() <= 0) {
					System.out.println("消费者：集合为空，消费者阻塞！");
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						obj.notify();
					}
				}
				String tmp = list.get(0);
				list.remove(0);
				System.out.println("消费者：取集合元素：" + tmp);
				obj.notify();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
