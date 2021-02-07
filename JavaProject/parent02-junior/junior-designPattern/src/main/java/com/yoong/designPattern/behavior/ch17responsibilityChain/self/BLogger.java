package com.yoong.designPattern.behavior.ch17responsibilityChain.self;

public class BLogger extends AbstractLogger {

    @Override
    public void write() {
        System.out.println("BBBBBBBBBBB");
        if (next != null) {
            next.write();
        } else {
            System.out.println("BLogger hasn't next");
        }
    }
}
