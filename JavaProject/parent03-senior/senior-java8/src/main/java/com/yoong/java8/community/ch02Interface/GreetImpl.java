package com.yoong.java8.community.ch02Interface;

/**
 * @Desc 接口实现类
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018-03-02 09:00:00
 * <p>
 * @Version 1.0
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
