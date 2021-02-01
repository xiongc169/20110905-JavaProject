package com.yoong.thread.book02.chap0602;

import java.util.concurrent.ConcurrentLinkedDeque;

public class AddTask implements Runnable {

	private ConcurrentLinkedDeque<String> list;

	public AddTask(ConcurrentLinkedDeque<String> list) {
		this.list = list;
	}

	public void run() {
		for (int i = 0; i < 10000; i++) {
			String name = Thread.currentThread().getName();
			list.add(name + ", Element: " + i);
		}
	}
}
