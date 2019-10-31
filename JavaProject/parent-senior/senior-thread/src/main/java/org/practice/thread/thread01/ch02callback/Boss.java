package org.practice.thread.thread01.ch02callback;

/**
 * @author yoong
 * <br>
 * @desc Boss
 * <br>
 * @date 2019/1/11 10:20
 */
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
