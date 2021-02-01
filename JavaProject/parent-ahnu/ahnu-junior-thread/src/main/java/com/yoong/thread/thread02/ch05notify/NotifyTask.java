package com.yoong.thread.thread02.ch05notify;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotifyTask implements Runnable {

    private Object obj;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public NotifyTask(Object obj) {
        this.obj = obj;
    }

    public void run() {
        synchronized (obj) {
            try {
                System.out.println(format.format(new Date()) + " NotifyTask Before ");
                obj.notify();
                obj.wait();
                System.out.println(format.format(new Date()) + " NotifyTask End ");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
