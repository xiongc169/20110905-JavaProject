package org.practice.primary.book01.chap14.thread02.ch13timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class MyTimeTask extends TimerTask {

    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void run() {
        System.out.println(format.format(new Date()) + " MyTimeTask.run Start...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            String msg = e.getMessage();
            System.out.println(msg);
        }
    }
}
