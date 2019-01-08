package org.practice.thread2.chap0407;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

public class RunnableTask implements Runnable {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    private String name;

    public RunnableTask() {
    }

    public RunnableTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        String greet = "Hello, " + name + " —— " + format.format(new Date());
        System.out.println(greet);
    }
}
