package com.yoong.designPattern.behavior.ch19memento.runoob;

public class Memento {

    private String state;

    public Memento() {
    }

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
