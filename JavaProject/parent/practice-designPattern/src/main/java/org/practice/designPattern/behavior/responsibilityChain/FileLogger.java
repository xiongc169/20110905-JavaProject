package org.practice.designPattern.behavior.responsibilityChain;

public class FileLogger extends AbstractLogger {

	public FileLogger(int level, AbstractLogger nextLogger) {
		super(level, nextLogger);
		this.currentLevel = level;
		this.nextLogger = nextLogger;
	}

	@Override
	protected void write(String message) {
		System.out.println("this is FileLogger");
	}
}
