package org.practice.primary.book01.chap14.book02.chap0113;

public class Task implements Runnable {

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
