package org.practice.thread1.ch03synch;

import java.util.ArrayList;

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

	public void insert(Thread thread) {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(thread.getName() + " 在插入数据 " + i);
				arrayList.add(i);
			}
		}
	}

}
