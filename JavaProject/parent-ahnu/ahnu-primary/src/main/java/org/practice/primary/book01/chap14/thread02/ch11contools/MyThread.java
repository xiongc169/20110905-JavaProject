package org.practice.primary.book01.chap14.thread02.ch11contools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

public class MyThread extends Thread {

    private int num;

    private Semaphore semaphore;

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public MyThread() {
    }

    public MyThread(int num, Semaphore se) {
        this.num = num;
        this.semaphore = se;
    }

    public void run() {
        try {
            semaphore.acquire();
            System.out.println(format.format(new Date()) + " " + num + " Begin... " + Thread.currentThread().getId());
            Thread.sleep(4000);
            System.out.println(format.format(new Date()) + " " + num + " End! " + Thread.currentThread().getId());
            semaphore.release();
        } catch (InterruptedException e) {
            String msg = e.getMessage();
            System.out.println(msg);
        }
    }
}
