package com.yoong.thread.thread01.ch03com;

import com.yoong.thread.thread01.model.Account;

/**
 * @Desc Java总结篇系列：Java多线程（三）
 * PS：线程通信
 * https://www.cnblogs.com/lwbqqyumidi/p/3821389.html
 * Java中的多线程你只要看这一篇就够了
 * http://www.cnblogs.com/wxd0108/p/5479442.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:06:00
 * <p>
 * @Version 1.0
 */
public class AppCom {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            producerTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void producerTest() {
        Object obj = new Object();
        Account account = new Account("20190103105152", 0);
        Integer consumerAmount = 100;
        Integer saveAmount = 100;

        ProducerTask producerTask = new ProducerTask(obj, account, saveAmount);
        ConsumerTask consumerTask = new ConsumerTask(obj, account, consumerAmount);

        consumerTask.start();
        producerTask.start();
    }
}
