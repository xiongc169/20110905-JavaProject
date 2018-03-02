package org.practice.designPattern.create.singleton;

public class SingletonInner {

	private static class SingletonHolder {
		private static final SingletonInner INSTANCE = new SingletonInner();
	}

	private SingletonInner() {
	}

	public static final SingletonInner getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
