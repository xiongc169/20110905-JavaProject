package org.practice.thread.ch02primary;

import org.practice.model.Account;

public class AtmRunnable implements Runnable {

    private Account account;

    private Integer drawAmount;

    public AtmRunnable(Account account, Integer drawAmount) {
        super();
        this.account = account;
        this.drawAmount = drawAmount;
    }

    public void run() {
        try {
            System.out.println("开始取钱...");
            synchronized (account) {
                if (account.getBalance() >= drawAmount) { // 1
                    Integer balance = account.getBalance() - drawAmount;
                    account.setBalance(balance);
                    System.out.println("取钱成功， 取钱为：" + drawAmount + "余额为：" + balance);
                } else {
                    System.out.println("余额为不足");
                }
            }
            System.out.println("取钱结束！");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
