package org.practice.designPattern.behavior.ch18command.runoob;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock {

    private String name;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    public Stock() {
    }

    public Stock(String name) {
        this.name = name;
    }

    public void buy() {
        String operation = format.format(new Date()) + ": Stock.buy() " + name;
        System.out.println(operation);
    }

    public void sell() {
        String operation = format.format(new Date()) + ": Stock.sell() " + name;
        System.out.println(operation);
    }
}
