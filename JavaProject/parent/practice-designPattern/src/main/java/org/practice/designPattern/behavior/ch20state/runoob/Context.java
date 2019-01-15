package org.practice.designPattern.behavior.ch20state.runoob;

/**
 * @author yoong
 * <br>
 * @desc Context
 * <br>
 * @date 2019/1/15 16:25
 */
public class Context {

    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
