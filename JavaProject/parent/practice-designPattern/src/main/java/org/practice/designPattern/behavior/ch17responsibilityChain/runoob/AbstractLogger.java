package org.practice.designPattern.behavior.ch17responsibilityChain.runoob;

public abstract class AbstractLogger {

    public int DEBUG = 0;

    public int INFO = 1;

    public int WARN = 2;

    public int ERROR = 3;

    protected int currentLevel = 0;

    protected AbstractLogger nextLogger;

    public AbstractLogger() {
    }

    public AbstractLogger(int level, AbstractLogger nextLogger) {
        this.currentLevel = level;
        this.nextLogger = nextLogger;
    }

    public void logger(int level, String message) {
        if (this.currentLevel < level) {
            write(message);
            if (nextLogger != null) {
                nextLogger.logger(level, message);
            } else {
                System.out.println("nextLogger is null");
            }
        }
    }

    abstract protected void write(String message);
}
