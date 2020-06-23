package org.practice.designPattern.struct.ch06adapter.community.obj;

import org.practice.designPattern.struct.ch06adapter.community.clazz.Source;
import org.practice.designPattern.struct.ch06adapter.community.clazz.Target;

public class Wrapper implements Target {

    private Source source;

    public Wrapper(Source source) {
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("This is Wrapper.method2()");
    }

    @Override
    public void method3() {
        System.out.println("This is Wrapper.method3()");
    }
}
