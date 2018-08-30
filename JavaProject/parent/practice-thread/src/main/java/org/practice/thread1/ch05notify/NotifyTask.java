package org.practice.thread1.ch05notify;

public class NotifyTask implements Runnable {

	private Object obj;

	public NotifyTask(Object obj) {
		this.obj = obj;
	}

	public void run() {
		synchronized (obj) {
			System.out.println("NotifyTask Before ");
			obj.notify();
			System.out.println("NotifyTask End ");
		}
	}

}
