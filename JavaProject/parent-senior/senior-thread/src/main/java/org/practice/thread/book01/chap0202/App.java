package org.practice.thread.book01.chap0202;

/**
 * 线程同步
 */
public class App {

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
