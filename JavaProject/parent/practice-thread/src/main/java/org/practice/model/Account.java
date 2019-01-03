package org.practice.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {

    private String accountNo;

    /**
     * 1、非线程同步
     */
//    private Integer balance;

    /**
     * 2、volatile
     */
//    private volatile Integer balance;

    /**
     * 3、ThreadLocal
     */
//    private static ThreadLocal<Integer> balance = new ThreadLocal<Integer>() {
//        @Override
//        protected Integer initialValue() {
//            return 0;
//        }
//    };

    /**
     * 4、AtomicInteger
     */
    private AtomicInteger balance = new AtomicInteger();

    public Account() {
    }

    public Account(String accountNo, Integer balances) {
        this.accountNo = accountNo;
        //1、非线程同步的getter、setter方法
//        this.balance = balances;
        //3、ThreadLocal的getter、setter方法
//        balance.set(balance.get() + balances);
        //4、AtomicInteger的getter、setter方法
        this.balance.addAndGet(balances);
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * 1、非线程同步的getter、setter方法
     * @return
     */
//    public Integer getBalance() {
//        return balance;
//    }
//    public void setBalance(Integer balance) {
//        this.balance = balance;
//    }

    /**
     * 3、ThreadLocal的getter、setter方法
     * @return
     */
//    public Integer getBalance() {
//        return balance.get();
//    }
//    public void setBalance(Integer balances) {
//        balance.set(balance.get() + balances);
//    }

    /**
     * 4、AtomicInteger的getter、setter方法
     *
     * @return
     */
    public Integer getBalance() {
        return balance.get();
    }

    public void setBalance(Integer balances) {
        this.balance.addAndGet(balances);
    }
}
