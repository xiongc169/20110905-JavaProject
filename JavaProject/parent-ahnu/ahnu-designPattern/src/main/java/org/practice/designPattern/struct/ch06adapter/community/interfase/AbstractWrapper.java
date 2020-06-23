package org.practice.designPattern.struct.ch06adapter.community.interfase;

import org.practice.designPattern.struct.ch06adapter.community.clazz.Target;

public class AbstractWrapper implements Target {

    @Override
    public void method1() {
    }

    @Override
    public void method2() {
        System.out.println("This is AbstractWrapper.method2()");
    }

    @Override
    public void method3() {
        System.out.println("This is AbstractWrapper.method3()");
    }
}
