package com.yoong.designPattern.behavior.ch20state.runoob;

public class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("StopState.doAction...");
        context.setState(this);
    }
}
