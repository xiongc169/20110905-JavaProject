package org.practice.thread1.ch05notify;

public class WaitTask implements Runnable {

	private Object obj;

	public WaitTask(Object obj) {
		this.obj = obj;
	}

	public void run() {

		synchronized (obj) {
			System.out.println("WaitTask Before ");
			try {
				obj.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("WaitTask End ");
		}

	}

}
