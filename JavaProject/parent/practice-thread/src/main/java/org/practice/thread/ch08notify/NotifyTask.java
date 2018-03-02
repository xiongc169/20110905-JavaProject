package org.practice.thread.ch08notify;

public class NotifyTask implements Runnable {

	private Object obj;

	public NotifyTask(Object obj) {
		this.obj = obj;
	}

	public void run() {
		synchronized (obj) {
			System.out.println("Before NotifyTask");
			obj.notify();
			System.out.println("End NotifyTask");
		}
	}

}
