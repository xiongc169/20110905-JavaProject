package com.yoong.thread.thread01.ch03com;

import com.yoong.thread.thread01.model.Account;

public class ProducerTask extends Thread {

    private Object obj;

    private Account account;

    private Integer saveAmount;

    public ProducerTask() {
    }

    public ProducerTask(Object obj, Account account, Integer saveAmount) {
        this.obj = obj;
        this.account = account;
        this.saveAmount = saveAmount;
    }

    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 0; i < 10; i++) {
                System.out.println("ProducerTask.run() Start...");
                try {
                    //System.out.println("ConsumerTask: 请输入存款金额");
                    //int saveAmount = System.in.read();
                    if (account.getBalance() > 0) {
                        System.out.println("ProducerTask: 余额大于0，不能存入，进入等待状态...");
                        obj.wait();
                    }
                    Integer balance = account.getBalance() + saveAmount;
                    account.setBalance(balance);
                    System.out.println("ProducerTask: 余额等于0，已存入");
                    obj.notifyAll();

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("ProducerTask.run() Start...");
            }
        }
    }
}
