package org.practice.primary.book01.chap06.cp641;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @Desc TalkingClock
 * @Author
 * @Date
 * @Version 1.0
 */
public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock() {
    }

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
        //外围类调用内部类构造函数
        //this.new TimePrinter();
    }

    public class TimePrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());
            //内部类引用外围类
            //TalkingClock.this.beep
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
