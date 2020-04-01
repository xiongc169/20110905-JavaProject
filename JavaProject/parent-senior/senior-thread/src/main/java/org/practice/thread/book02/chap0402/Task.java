package org.practice.thread.book02.chap0402;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

    private String name;

    private Date initDate;

    public Task(String name) {
        this.name = name;
        this.initDate = new Date();
    }

    public void run() {

        System.out.printf("%s, TaskName: %s, Created On: %s \n", Thread.currentThread().getName(), name, initDate);
        System.out.printf("%s, TaskName: %s, Started On: %s \n", Thread.currentThread().getName(), name, new Date());

        try {
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s, TaskName: %s, Doing task time: %s \n", Thread.currentThread().getName(), name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s, TaskName: %s, Finished On: %s \n", Thread.currentThread().getName(), name, new Date());

    }

}
