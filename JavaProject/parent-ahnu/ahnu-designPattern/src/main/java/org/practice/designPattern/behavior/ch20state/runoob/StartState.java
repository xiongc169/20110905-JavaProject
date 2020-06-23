package org.practice.designPattern.behavior.ch20state.runoob;

public class StartState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("StartState.doAction...");
        context.setState(this);
    }
}
