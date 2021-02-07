package com.yoong.thread.book02.chap0407;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    private String name;

    public Task() {
    }

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        //Thread.sleep(5000);
        String greet = "Hello, " + name + " —— " + format.format(new Date());
        System.out.println(greet);
        return greet;
    }
}
