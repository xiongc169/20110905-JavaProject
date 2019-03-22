package org.practice.designPattern.struct.ch06adapter.adapter.interfase;

import org.practice.designPattern.struct.ch06adapter.adapter.clazz.Target;

/**
 * @author yoong
 * <br>
 * @desc AbstractWrapper
 * <br>
 * @date 2019/1/15 10:33
 */
public class AbstractWrapper implements Target {
    @Override
    public void methodB() {
        System.out.println("This is AbstractWrapper.methodB()");
    }

    @Override
    public void methodC() {
        System.out.println("This is AbstractWrapper.methodC()");
    }
}
