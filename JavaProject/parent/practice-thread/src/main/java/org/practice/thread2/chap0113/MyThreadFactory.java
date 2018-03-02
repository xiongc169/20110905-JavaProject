package org.practice.thread2.chap0113;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

	private int count;

	private String name;

	private List<String> states;

	public MyThreadFactory(String name) {
		this.count = 0;
		this.name = name;
		this.states = new ArrayList<String>();
	}

	public Thread newThread(Runnable r) {

		Thread thread = new Thread(r);
		count++;
		states.add(String.format("%d \n", thread.getId()));
		return thread;
	}

}
