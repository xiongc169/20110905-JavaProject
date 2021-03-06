package com.yoong.thread.thread01.ch02control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

import com.yoong.thread.thread01.model.Person;

public class MyThread extends Thread {

    private ReentrantLock lock = new ReentrantLock();

    private Person person;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public MyThread() {
    }

    public MyThread(Person person) {
        this.person = person;
    }

    public MyThread(Runnable runnable) {
        super(runnable);
    }

    /**
     * 线程中断的测试
     */
    @Override
    public void run() {
        boolean isInterrupted = Thread.currentThread().isInterrupted();
        try {
            while (!isInterrupted) {
                System.out.println(String.format("MyThread: %s %s %s %s %s", format.format(new Date()), Thread.currentThread().getId(), Thread.currentThread().getName(), Thread.currentThread().getState(), isInterrupted));
                //Thread.sleep(500);
                isInterrupted = Thread.currentThread().isInterrupted();
            }
            System.out.println(String.format("MyThread: %s %s %s %s %s", format.format(new Date()), Thread.currentThread().getId(), Thread.currentThread().getName(), Thread.currentThread().getState(), isInterrupted));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    public void stopThread() {
        this.stop();
    }
}
