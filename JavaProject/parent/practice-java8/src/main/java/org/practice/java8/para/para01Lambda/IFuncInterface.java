package org.practice.java8.para.para01Lambda;

/**
 * 
 * @author yoong
 *
 * @description 函数式接口
 *
 * @date 2018年3月30日
 *
 * @version 1.0
 *
 */
@FunctionalInterface
public interface IFuncInterface {

	/**
	 * 接口的默认方法
	 */
	default void defaultMethod() {
		System.out.println("This is default method");
	}

	/**
	 * 接口的静态方法
	 */
	static void staticMethod() {
		System.out.println("This is static method");
	}

	void print(Object obj);
}
