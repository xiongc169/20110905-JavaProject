package org.practice.thread.ch08notify2;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {

		Object obj = new Object();
		ArrayList<String> list = new ArrayList<String>();

		Consumer consumer = new Consumer(obj, list);
		Thread conThread = new Thread(consumer);

		Producer producer = new Producer(obj, list);
		Thread proThread = new Thread(producer);

		conThread.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		proThread.start();

	}

}
