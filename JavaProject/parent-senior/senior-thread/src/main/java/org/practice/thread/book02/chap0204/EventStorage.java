package org.practice.thread.book02.chap0204;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {

	private int maxSize;

	private List<Date> storage;

	public EventStorage() {
		this.maxSize = 10;
		this.storage = new LinkedList<Date>();
	}

	public synchronized void set() {
		if (this.storage.size() >= this.maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		storage.add(new Date());
		System.out.printf("Set Size: %d\n", this.storage.size());
		notifyAll();
	}

	public synchronized void get() {
		if (this.storage.size() <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.printf("Get: %d, %s\n", this.storage.size(), ((LinkedList<?>) this.storage).poll());

	}

}
