package org.practice.quartz.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Desc App
 * @Author
 * @Date
 * @Version 1.0
 */
public class TimeApp {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(format.format(new Date()));
            }
        };
        timer.schedule(timerTask, 1000, 2000);
    }
}

