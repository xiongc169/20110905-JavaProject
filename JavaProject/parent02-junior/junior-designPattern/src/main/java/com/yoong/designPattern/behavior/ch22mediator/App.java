package com.yoong.designPattern.behavior.ch22mediator;

import com.yoong.designPattern.behavior.ch22mediator.runoob.User;

/**
 * @Desc 中介者模式 (Mediator Pattern)
 * http://www.runoob.com/design-pattern/mediator-pattern.html
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
