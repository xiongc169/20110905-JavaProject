package org.practice.thread.ch08notify2;

import java.util.ArrayList;
import java.util.List;

public class Producer implements Runnable {

	private Object obj;

	private List<String> list = new ArrayList<String>();

	public Producer(Object obj, ArrayList<String> list) {
		this.obj = obj;
		this.list = list;
	}

	public void run() {
		while (true) {
			synchronized (obj) {
				if (list.size() >= 10) {
					System.out.println("生产者：集合已满，生产者阻塞！");
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						obj.notify();
					}
				}
				String tmp = "集合元素：" + Math.random();
				list.add(tmp);
				System.out.println("生产者：添加集合元素：" + tmp);
				obj.notify();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
