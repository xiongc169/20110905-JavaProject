package org.practice.designPattern.create.singleton;

/**
 * 懒汉式 & 线程不安全 <br>
 * 懒汉式 & 线程安全 <br>
 * 饿汉式 <br>
 * 双检索 <br>
 * http://www.runoob.com/design-pattern/singleton-pattern.html
 * 
 * @author Administrator
 *
 */
public class SingleObject {

	public SingleObject() {
	}

	public static SingleObject getInstance() {
		return Handler.instance;
	}

	public static class Handler {
		private static final SingleObject instance = new SingleObject();
	}

}
