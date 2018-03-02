package org.practice.thread.ch08notify;

public class App {

	public static void main(String[] args) {

		Object obj = new Object();

		WaitTask wait = new WaitTask(obj);
		Thread waitThread = new Thread(wait);
		waitThread.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		NotifyTask notify = new NotifyTask(obj);
		Thread notifyThread = new Thread(notify);
		notifyThread.start();

	}

}
