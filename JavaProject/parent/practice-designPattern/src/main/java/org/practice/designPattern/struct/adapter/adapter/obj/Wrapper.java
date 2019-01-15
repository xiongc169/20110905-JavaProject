package org.practice.designPattern.struct.adapter.adapter.obj;

import org.practice.designPattern.struct.adapter.adapter.clazz.Source;
import org.practice.designPattern.struct.adapter.adapter.clazz.Target;

/**
 * @author yoong
 * <br>
 * @desc Wrapper
 * <br>
 * @date 2019/1/15 10:19
 */
public class Wrapper implements Target {

    private Source source;

    public Wrapper() {
    }

    public Wrapper(Source source) {
        this.source = source;
    }

    @Override
    public void methodB() {
        System.out.println("This is Wrapper.methodB() + Source.methodA()");
        source.methodA();
    }

    @Override
    public void methodC() {
        System.out.println("This is Wrapper.methodB()");
    }
}
