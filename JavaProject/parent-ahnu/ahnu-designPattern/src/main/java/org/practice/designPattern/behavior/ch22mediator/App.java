package org.practice.designPattern.behavior.ch22mediator;

import org.practice.designPattern.behavior.ch22mediator.runoob.User;

/**
 * @author yoong
 * <br>
 * @desc 中介者模式 (Mediator Pattern)
 * http://www.runoob.com/design-pattern/mediator-pattern.html
 * <br>
 * @date 2019/1/16 10:36
 */
public class App {
    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            mediator_runoob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void mediator_runoob() {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
