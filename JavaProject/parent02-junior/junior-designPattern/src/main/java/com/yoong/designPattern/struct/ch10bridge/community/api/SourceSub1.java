package com.yoong.designPattern.struct.ch10bridge.community.api;

public class SourceSub1 implements Source {

    @Override
    public void method() {
        System.out.println("SourceSub1.method()");
    }
}
