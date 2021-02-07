package com.yoong.designPattern.struct.ch06adapter.community.clazz;

public class Adapter extends Source implements Target {

    @Override
    public void method2() {
        System.out.println("This is Adapter.method2()");
    }

    @Override
    public void method3() {
        System.out.println("This is Adapter.method3()");
    }

}
