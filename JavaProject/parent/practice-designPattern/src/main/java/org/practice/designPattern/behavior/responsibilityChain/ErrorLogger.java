package org.practice.designPattern.behavior.responsibilityChain;

public class ErrorLogger extends AbstractLogger {

	public ErrorLogger(int level, AbstractLogger nextLogger) {
		super(level, nextLogger);
		this.currentLevel = level;
		this.nextLogger = nextLogger;
	}

	@Override
	protected void write(String message) {
		System.out.println("this is ErrorLogger");
	}

}
