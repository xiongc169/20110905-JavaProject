package org.practice.designPattern.behavior.ch17responsibilityChain.self;

public class CLogger extends AbstractLogger {

    @Override
    public void write() {
        System.out.println("CCCCCCCCCCCC");
        if (next != null) {
            next.write();
        } else {
            System.out.println("CLogger hasn't next");
        }
    }
}
