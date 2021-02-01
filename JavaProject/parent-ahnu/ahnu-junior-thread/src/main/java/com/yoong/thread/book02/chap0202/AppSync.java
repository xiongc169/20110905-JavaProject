package com.yoong.thread.book02.chap0202;

/**
 * @Desc 《Java 7并发编程实战手册》
 * PS：2.2、使用synchronized实现同步方法
 * https://www.jb51.net/books/404868.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppSync {

    /**
     * 入口函数
     */
    public static void main(String[] args) {

        Account account = new Account();
        account.setBalance(2000);

        Company company = new Company(account);
        Thread compThread = new Thread(company);

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        compThread.start();
        bankThread.start();

        try {
            // 使用过join()方法等待这两个线程运行完
            compThread.join();
            bankThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("account.balance: " + account.balance);
    }
}
