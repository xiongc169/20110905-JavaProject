package org.practice.thread.ch03pool;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

	public MyThreadFactory(){}
	
	public Thread newThread(Runnable r) {

		Thread thread = new Thread(r);
		return thread;
	}

}
