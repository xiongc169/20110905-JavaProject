package org.practice.java8.para.para02Interface;

/**
 * @author yoong
 * @version 1.0
 * @description 函数式接口
 * @date 2018年3月30日
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
