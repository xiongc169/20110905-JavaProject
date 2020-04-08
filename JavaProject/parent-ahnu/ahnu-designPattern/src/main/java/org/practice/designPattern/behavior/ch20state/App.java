package org.practice.designPattern.behavior.ch20state;

import org.practice.designPattern.behavior.ch20state.runoob.Context;
import org.practice.designPattern.behavior.ch20state.runoob.StartState;
import org.practice.designPattern.behavior.ch20state.runoob.State;
import org.practice.designPattern.behavior.ch20state.runoob.StopState;

/**
 * @author yoong
 * <br>
 * @desc 状态模式
 * http://www.runoob.com/design-pattern/state-pattern.html
 * <br>
 * @date 2019/1/15 16:10
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            state_runoob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void state_runoob() {
        Context context = new Context();
        State start = new StartState();
        State stop = new StopState();

        start.doAction(context);
        System.out.println(context.getState().toString());

        stop.doAction(context);
        System.out.println(context.getState().toString());
    }
}
