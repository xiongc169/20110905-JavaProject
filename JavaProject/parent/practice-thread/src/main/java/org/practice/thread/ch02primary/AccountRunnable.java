package org.practice.thread.ch02primary;

import org.practice.model.Account;

public class AccountRunnable implements Runnable {

	private Account account;

	private double drawAmount;

	public AccountRunnable(Account account, double drawAmount) {
		super();
		this.account = account;
		this.drawAmount = drawAmount;
	}

	public void run() {
		synchronized (account) {
			if (account.getBalance() >= drawAmount) { // 1
				System.out.println("取钱成功， 取出钱数为：" + drawAmount);
				double balance = account.getBalance() - drawAmount;
				account.setBalance(balance);
				System.out.println("余额为：" + balance);
			} else {
				System.out.println("余额为不足");
			}
		}
	}
}
