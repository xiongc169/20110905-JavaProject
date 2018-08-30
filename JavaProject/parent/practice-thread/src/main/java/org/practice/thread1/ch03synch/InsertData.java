package org.practice.thread1.ch03synch;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yoong
 *
 * @desc InsertData.java
 *
 * @date 2018年8月29日
 *
 */
public class InsertData {

	private ArrayList<Integer> arrayList = new ArrayList<Integer>();

	Lock lock = new ReentrantLock();

	public void insert(Thread thread) {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(thread.getName() + " 在插入数据 " + i);
				arrayList.add(i);
			}
		}
	}

	public void insert4Lock(Thread thread) {
		lock.lock();
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(thread.getName() + " 在插入数据 " + i);
				arrayList.add(i);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
