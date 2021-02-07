package com.yoong.java8.community.ch01Lambda;

/**
 * @Desc IFuncInterface
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018-03-02 09:00:00
 * <p>
 * @Version 1.0
 */
@FunctionalInterface
public interface IFuncInterface {

    /**
     * 接口的默认方法
     */
    default void defaultMethod() {
        System.out.println("Enter IFuncInterface.defaultMethod()");
        System.out.println("Exit IFuncInterface.defaultMethod()");
    }

    /**
     * 接口的静态方法
     */
    static void staticMethod() {
        System.out.println("Enter IFuncInterface.staticMethod()");
        System.out.println("Exit IFuncInterface.staticMethod()");
    }

    void print(Object obj);
}
