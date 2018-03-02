package org.practice.designPattern.struct.facade;

/**
 * 外观模式<br>
 * http://www.runoob.com/design-pattern/facade-pattern.html
 *
 */
public class App {
	public static void main(String[] args) {

		ShapeMaker maker = new ShapeMaker();

		maker.drawRectangle();
		maker.drawSquare();
		maker.drawCircle();
	}

}
