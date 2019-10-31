package org.practice.designPattern.struct.ch06adapter.adapter.clazz;

/**
 * @author yoong
 * <br>
 * @date 2018年6月12日
 */
public class Adapter extends Source implements Target {

    @Override
    public void methodB() {
        System.out.println("This is Adapter.methodB()");
    }

    @Override
    public void methodC() {
        System.out.println("This is Adapter.methodC()");
    }

}
