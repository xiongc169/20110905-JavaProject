package org.practice.thread2.chap0201;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

	public double blance;

	private Lock lock = new ReentrantLock();

	public double getBlance() {
		return blance;
	}

	public void setBlance(double blance) {
		this.blance = blance;
	}

	public void addAmount(double amount) {
		// System.out.println("before addAmount");

		lock.lock();
		try {
			double tmp = blance;
			Thread.sleep(10);
			tmp += amount;
			this.blance = tmp;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void substractAmount(double amount) {
		// System.out.println("before substractAmount");
		lock.lock();
		try {
			double tmp = blance;
			Thread.sleep(10);
			tmp -= amount;
			this.blance = tmp;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
