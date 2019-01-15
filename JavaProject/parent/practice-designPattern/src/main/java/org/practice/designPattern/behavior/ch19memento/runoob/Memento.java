package org.practice.designPattern.behavior.ch19memento.runoob;

/**
 * @author yoong
 * <br>
 * @desc Memento
 * <br>
 * @date 2019/1/15 15:54
 */
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
