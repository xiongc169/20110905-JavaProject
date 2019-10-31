package org.practice.java8.para.para01Lambda;

/**
 * @author yoong
 * @version 1.0
 * @description 函数式接口
 * @date 2018年3月30日
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
