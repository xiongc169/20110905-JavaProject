package org.practice.thread1.ch13timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Java并发编程：Timer和TimerTask（转载）
 * http://www.cnblogs.com/dolphin0520/p/3938991.html
 *
 * @author Administrator
 */
public class TimerDemo {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            timerTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void timerTest() {
        System.out.println(new Date().toString() + "：this is before timer.schedule()");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date().toString() + "：this is timertask()");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    String msg = e.getMessage();
                    System.out.println(msg);
                }
            }
        }, 3000, 1000);

        System.out.println(new Date().toString() + "：this is after timer.schedule()");
    }

}
