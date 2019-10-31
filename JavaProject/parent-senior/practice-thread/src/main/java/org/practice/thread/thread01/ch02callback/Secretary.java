package org.practice.thread.thread01.ch02callback;

import java.util.concurrent.TimeUnit;

/**
 * @author yoong
 * <br>
 * @desc Secretary
 * <br>
 * @date 2019/1/11 10:20
 */
public class Secretary implements Runnable {

    private Boss boss;

    public Secretary() {
    }

    public Secretary(Boss boss) {
        this.boss = boss;
    }

    @Override
    public void run() {
        try {
            long threadId = Thread.currentThread().getId();
            String threadName = Thread.currentThread().getName();
            String output = "Secretary threadId: " + threadId + "; Secretary threadName: " + threadName;
            System.out.println(output);
            TimeUnit.SECONDS.sleep(10);

            boss.receiveResult(output);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
