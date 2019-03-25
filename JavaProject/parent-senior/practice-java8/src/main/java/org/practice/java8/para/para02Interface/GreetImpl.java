package org.practice.java8.para.para02Interface;

/**
 * @author yoong
 * @version 1.0
 * @description 接口实现类
 * @date 2018年3月30日
 */
public class GreetImpl implements IGreet {

    @Override
    public void myMethod() {
        System.out.println("Enter GreetImpl.myMethod()");
        System.out.println("Exit GreetImpl.myMethod()");
    }

    public void defaultMethod() {
        System.out.println("Enter GreetImpl.defaultMethod()");
        System.out.println("Exit GreetImpl.defaultMethod()");
    }

    public static void staticMethod() {
        System.out.println("Enter GreetImpl.staticMethod()");
        System.out.println("Exit GreetImpl.staticMethod()");
    }
}
