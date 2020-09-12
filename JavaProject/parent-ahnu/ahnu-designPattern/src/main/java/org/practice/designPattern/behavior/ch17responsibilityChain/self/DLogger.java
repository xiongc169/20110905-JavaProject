package org.practice.designPattern.behavior.ch17responsibilityChain.self;

public class DLogger extends AbstractLogger {

    @Override
    public void write() {
        System.out.println("DDDDDDDDDDDDD");
        if (next != null) {
            next.write();
        } else {
            System.out.println("DLogger hasn't next");
        }
    }
}
