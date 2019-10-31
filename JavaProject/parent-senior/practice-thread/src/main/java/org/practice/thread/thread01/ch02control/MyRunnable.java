package org.practice.thread.thread01.ch02control;

import org.practice.thread.thread01.ch02callback.Boss;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author yoong
 * <br>
 * @desc MyRunnable
 * <br>
 * @date 2019/1/11 10:20
 */
public class MyRunnable implements Runnable {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

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
            while (!Thread.currentThread().isInterrupted()) {
                TimeUnit.SECONDS.sleep(1);//处于sleep状态时被中断，会抛异常：sleep interrupted，此时线程状态为RUNNABLE
                System.out.printf("%s MyRunnable.run By %s %s \n", format.format(new Date()), Thread.currentThread().getName(), Thread.currentThread().isInterrupted());
            }
            System.out.printf("%s MyRunnable.run By %s %s \n", format.format(new Date()), Thread.currentThread().getName(), Thread.currentThread().isInterrupted());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
