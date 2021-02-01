package com.yoong.thread.thread01.ch02control;

import com.yoong.thread.thread01.ch02callback.Boss;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyRunnable implements Runnable {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public volatile boolean exit = false;

    private Boss boss;

    public MyRunnable() {
    }

    public MyRunnable(Boss boss) {
        this.boss = boss;
    }

    @Override
    public void run() {
        try {
            //循环条件：true\Thread.currentThread().isInterrupted()
            //while (!Thread.currentThread().isInterrupted()) {
            while (!exit) {
                //TimeUnit.SECONDS.sleep(1);//处于sleep状态时被中断，会抛异常：sleep interrupted，此时线程状态为RUNNABLE
                System.out.printf("MyRunnable: %s %s %s %s %s\n", format.format(new Date()), Thread.currentThread().getId(), Thread.currentThread().getName(), Thread.currentThread().getState(), Thread.currentThread().isInterrupted());
            }
            System.out.printf("MyRunnable: %s %s %s %s %s\n", format.format(new Date()), Thread.currentThread().getId(), Thread.currentThread().getName(), Thread.currentThread().getState(), Thread.currentThread().isInterrupted());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
