package org.practice.designPattern.behavior.responsibilityChain.runoob;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level, AbstractLogger nextLogger) {
        this.currentLevel = level;
        this.nextLogger = nextLogger;
    }

    @Override
    protected void write(String message) {
        System.out.println("ErrorLogger: " + message);
    }

}
