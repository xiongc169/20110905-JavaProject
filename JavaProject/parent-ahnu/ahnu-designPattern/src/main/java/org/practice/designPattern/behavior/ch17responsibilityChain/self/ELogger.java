package org.practice.designPattern.behavior.ch17responsibilityChain.self;

public class ELogger extends AbstractLogger {

    @Override
    public void write() {
        System.out.println("EEEEEEEEEEEEEE");
        if (next != null) {
            next.write();
        } else {
            System.out.println("ELogger hasn't next");
        }
    }
}
