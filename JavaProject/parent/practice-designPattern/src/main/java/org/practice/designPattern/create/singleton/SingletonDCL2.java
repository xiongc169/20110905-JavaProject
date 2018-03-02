package org.practice.designPattern.create.singleton;

public class SingletonDCL2 {

	private volatile static SingletonDCL2 singleton;

	private SingletonDCL2() {
	}

	public static SingletonDCL2 getInstance() {
		if (singleton == null) {
			synchronized (SingletonDCL2.class) {
				if (singleton == null) {
					singleton = new SingletonDCL2();
				}
			}
		}
		return singleton;
	}
}
