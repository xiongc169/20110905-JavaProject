package org.practice.thread2.chap0602;

import java.util.concurrent.ConcurrentLinkedDeque;

public class App {

	public static void main(String[] args) {

		ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<String>();

		Thread[] threads = new Thread[100];
		for (int i = 0; i < threads.length; i++) {
			AddTask add = new AddTask(list);
			threads[i] = new Thread(add);
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("List Size:%d \n", list.size());

		for (int i = 0; i < threads.length; i++) {
			PollTask poll = new PollTask(list);
			threads[i] = new Thread(poll);
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("List Size:%d \n", list.size());
	}
}
