package org.practice.primary.book01.chap14.thread02.ch05notify;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitTask implements Runnable {

    private Object obj;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public WaitTask(Object obj) {
        this.obj = obj;
    }

    public void run() {
        synchronized (obj) {
            try {
                System.out.println(format.format(new Date()) + " WaitTask Before ");
                obj.wait();
                System.out.println(format.format(new Date()) + " WaitTask End ");
                obj.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
