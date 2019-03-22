package org.practice.designPattern.behavior.ch20state.runoob;

/**
 * @author yoong
 * <br>
 * @desc StopState
 * <br>
 * @date 2019/1/15 16:31
 */
public class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("StopState.doAction...");
        context.setState(this);
    }
}
