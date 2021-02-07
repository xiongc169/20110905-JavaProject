package com.yoong.designPattern.behavior.ch17responsibilityChain.runoob;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level, AbstractLogger nextLogger) {
        this.currentLevel = level;
        this.nextLogger = nextLogger;
    }

    @Override
    protected void write(String message) {
        System.out.println("ConsoleLogger: " + message);
    }
}
