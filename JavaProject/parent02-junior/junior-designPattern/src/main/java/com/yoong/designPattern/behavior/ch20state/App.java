package com.yoong.designPattern.behavior.ch20state;

import com.yoong.designPattern.behavior.ch20state.runoob.Context;
import com.yoong.designPattern.behavior.ch20state.runoob.StartState;
import com.yoong.designPattern.behavior.ch20state.runoob.State;
import com.yoong.designPattern.behavior.ch20state.runoob.StopState;

/**
 * @Desc 状态模式
 * http://www.runoob.com/design-pattern/state-pattern.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年7月4日
 * <p>
 * @Version 1.0
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
