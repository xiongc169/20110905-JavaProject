package org.practice.primary.book01.chap14.thread01.ch02callback;

public class Boss {

    private String name;

    public Boss() {
    }

    public Boss(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void receiveResult(String result) {
        System.out.println("Boss.receiveResult(): " + result);
    }
}
