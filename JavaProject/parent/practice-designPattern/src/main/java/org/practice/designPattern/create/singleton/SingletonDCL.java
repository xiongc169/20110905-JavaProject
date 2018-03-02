package org.practice.designPattern.create.singleton;

/**
 * 单例模式 双重检索
 * 
 * @author Administrator
 *
 */
public class SingletonDCL {

	private static volatile SingletonDCL instance;

	private SingletonDCL() {
	}

	public static SingletonDCL getSingletonDCL() {
		if (instance == null) {
			synchronized (SingletonDCL.class) {
				if (instance == null) {
					instance = new SingletonDCL();
				}
			}
		}
		return instance;
	}

	public void getInstance() {
		if (instance == null) {
			synchronized (this) {
				if (instance == null) {
					instance = new SingletonDCL();
				}
			}
		}
	}

}
