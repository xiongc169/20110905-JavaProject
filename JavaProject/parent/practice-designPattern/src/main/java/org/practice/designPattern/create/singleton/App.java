package org.practice.designPattern.create.singleton;

/**
 * 单例模式<br>
 * http://www.runoob.com/design-pattern/singleton-pattern.html
 * 
 */
public class App {

	public static void main(String[] args) {

		SingleObject so = SingleObject.getInstance();
		SingleObject so2 = SingleObject.getInstance();

		SingleObject so3 = new SingleObject();
		SingleObject so4 = new SingleObject();

		if (so3 == so4) {
			System.out.println("so==so2");
		} else {
			System.out.println("so!=so2");
		}
	}

}
