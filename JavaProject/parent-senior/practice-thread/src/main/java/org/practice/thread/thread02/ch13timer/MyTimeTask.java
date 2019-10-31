package org.practice.thread.thread02.ch13timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * @author yoong
 *
 * @desc MyTimeTask
 *
 * @date 2019/1/10 10:39
 */
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
