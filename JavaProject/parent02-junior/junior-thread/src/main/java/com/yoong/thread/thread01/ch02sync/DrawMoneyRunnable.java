package com.yoong.thread.thread01.ch02sync;

import com.yoong.thread.thread01.model.Account;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DrawMoneyRunnable implements Runnable {

    private Lock lock = new ReentrantLock();

    private Account account;

    private Integer drawAmount;

    public DrawMoneyRunnable(Account account, Integer drawAmount) {
        super();
        this.account = account;
        this.drawAmount = drawAmount;
    }

    //synchronized
    public void run() {
        try {
            System.out.println("开始取钱...");
//            lock.lock();
//            synchronized (account) {
                if (account.getBalance() >= drawAmount) { // 1
                    Integer balance = account.getBalance() - drawAmount;
                    TimeUnit.MILLISECONDS.sleep(500);
                    account.setBalance(balance);
                    System.out.println("取钱成功， 取钱为：" + drawAmount + "余额为：" + balance);
                } else {
                    System.out.println("余额为不足");
                }
//            }
            System.out.println("取钱结束！");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
//            lock.unlock();
        }
    }
}
