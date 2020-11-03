package org.practice.thread.thread02.ch09pool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyRunnable implements Runnable {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public void run() {
        // synchronized (this) {
        // for (int i = 0; i < 10; i++) {
        String output = String.format("MyRunnable: %s %s %s %s %s", format.format(new Date()), Thread.currentThread().getId(), Thread.currentThread().getName(), Thread.currentThread().getState(), Thread.currentThread().isInterrupted());
        System.out.println(output);
        // }
        // }
    }
}
