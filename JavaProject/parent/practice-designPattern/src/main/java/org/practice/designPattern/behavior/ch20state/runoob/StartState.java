package org.practice.designPattern.behavior.ch20state.runoob;

/**
 * @author yoong
 * <br>
 * @desc StartState
 * <br>
 * @date 2019/1/15 16:25
 */
public class StartState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("StartState.doAction...");
        context.setState(this);
    }
}
