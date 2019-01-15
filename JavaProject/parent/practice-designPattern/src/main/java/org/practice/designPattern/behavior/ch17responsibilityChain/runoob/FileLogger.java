package org.practice.designPattern.behavior.ch17responsibilityChain.runoob;

public class FileLogger extends AbstractLogger {

    public FileLogger(int level, AbstractLogger nextLogger) {
        this.currentLevel = level;
        this.nextLogger = nextLogger;
    }

    @Override
    protected void write(String message) {
        System.out.println("FileLogger: " + message);
    }
}
