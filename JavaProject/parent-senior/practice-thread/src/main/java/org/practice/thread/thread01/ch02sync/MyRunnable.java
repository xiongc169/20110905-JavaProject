package org.practice.thread.thread01.ch02sync;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chaoxiong
 * @since 2015-10-19 15:45:45
 */
public class MyRunnable implements Runnable {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public void run() {
        // synchronized (this) {
        // for (int i = 0; i < 10; i++) {
        String output = String.format("%s MyRunnable %s  %d", format.format(new Date()), Thread.currentThread().getName(), Thread.currentThread().getId());
        System.out.println(output);
        // }
        // }
    }

}
