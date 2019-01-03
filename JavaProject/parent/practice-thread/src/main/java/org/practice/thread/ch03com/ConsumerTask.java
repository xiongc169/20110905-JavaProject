package org.practice.thread.ch03com;

import org.practice.model.Account;

public class ConsumerTask extends Thread {

    private Object obj;

    private Account account;

    private Integer consumerAmount;

    public ConsumerTask() {
    }

    public ConsumerTask(Object obj, Account account, Integer consumerAmount) {
        this.obj = obj;
        this.account = account;
        this.consumerAmount = consumerAmount;
    }

    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 0; i < 10; i++) {
                System.out.println("ConsumerTask.run() Start...");
                try {
                    //System.out.println("ConsumerTask: 请输入取款金额");
                    //int consumerAmount = System.in.read();
                    if (account.getBalance() < consumerAmount) {
                        System.out.println("ConsumerTask: 余额不足，不能取出，进入等待状态...");
                        obj.wait();
                    }
                    Integer balance = account.getBalance() - consumerAmount;
                    account.setBalance(balance);
                    System.out.println("ConsumerTask: 余额充足，已取出");
                    obj.notifyAll();

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("ConsumerTask.run() Finished");
            }
        }
    }
}
