package org.practice.designPattern.behavior.responsibilityChain;

public abstract class AbstractLogger {

	public int abstractLevel = 0;

	public int consoleLevel = 1;

	public int errorLevel = 2;

	public int fileLevel = 3;

	protected int currentLevel = 0;

	protected AbstractLogger nextLogger;

	public AbstractLogger(int level, AbstractLogger nextLogger) {
		this.currentLevel = abstractLevel;
		this.nextLogger = nextLogger;
	}

	public void logger(int level, String message) {
		if (level != this.currentLevel) {
			if (nextLogger != null) {
				nextLogger.logger(level, message);
			} else {
				System.out.println("nextLogger is null");
			}

		} else {
			write(message);
		}
	}

	abstract protected void write(String message);
}
