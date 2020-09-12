package org.practice.designPattern.behavior.ch17responsibilityChain.self;

public class ALogger extends AbstractLogger {

    @Override
    public void write() {
        System.out.println("AAAAAAAAAA");
        if (next != null) {
            next.write();
        } else {
            System.out.println("ALogger hasn't next");
        }
    }
}
