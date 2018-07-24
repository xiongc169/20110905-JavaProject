package org.practice.designPattern.struct.adapter.player03;

/**
 * @author yoong
 *
 * @date 2018年6月12日
 *
 */
public class App {

	/**
	 *
	 */
	public static void main(String[] args) {

		Target target = new Adapter();
		target.methodB();
		target.methodC();

	}

}
