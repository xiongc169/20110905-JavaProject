package org.practice.designPattern.behavior.responsibilityChain;

public class ConsoleLogger extends AbstractLogger {

	public ConsoleLogger(int level, AbstractLogger nextLogger) {
		super(level, nextLogger);
		this.currentLevel = level;
		this.nextLogger = nextLogger;
	}

	@Override
	protected void write(String message) {
		System.out.println("this is ConsoleLogger");
	}
}
