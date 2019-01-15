package org.practice.designPattern.behavior.ch19memento.runoob;

/**
 * @author yoong
 * <br>
 * @desc Originator
 * <br>
 * @date 2019/1/15 15:55
 */
public class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        this.state = memento.getState();
    }
}
