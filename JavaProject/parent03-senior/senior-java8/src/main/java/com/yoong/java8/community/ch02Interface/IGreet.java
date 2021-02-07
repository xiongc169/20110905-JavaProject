package com.yoong.java8.community.ch02Interface;

/**
 * @Desc 函数式接口
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018-03-02 09:00:00
 * <p>
 * @Version 1.0
 */
public interface IGreet {

    default void defaultMethod() {
        System.out.println("Enter IGreet.defaultMethod()");
        System.out.println("Exit IGreet.defaultMethod()");
    }

    static void staticMethod() {
        System.out.println("Enter IGreet.staticMethod()");
        System.out.println("Exit IGreet.staticMethod()");
    }

    void myMethod();

}
