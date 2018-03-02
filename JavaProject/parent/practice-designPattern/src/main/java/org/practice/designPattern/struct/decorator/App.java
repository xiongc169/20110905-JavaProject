package org.practice.designPattern.struct.decorator;

/**
 * 装饰者模式<br>
 * http://www.runoob.com/design-pattern/decorator-pattern.html
 * 
 * @author Administrator
 *
 */
public class App {

	public static void main(String[] args) {

		Shape circle = new Circle();

		Shape redCircle = new RedShapeDecorator(new Circle());

		Shape redRectangle = new RedShapeDecorator(new Rectangle());
		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("\nCircle of red border");
		redCircle.draw();

		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}

}
