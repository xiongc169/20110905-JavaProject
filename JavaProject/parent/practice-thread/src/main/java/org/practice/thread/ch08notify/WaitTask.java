package org.practice.thread.ch08notify;

public class WaitTask implements Runnable {

	private Object obj;

	public WaitTask(Object obj) {
		this.obj = obj;
	}

	public void run() {

		synchronized (obj) {
			System.out.println("Before WaitTask");
			try {
				obj.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("End WaitTask");
		}

	}

}
