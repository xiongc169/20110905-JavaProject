package org.practice.designPattern.struct.ch09facade;

import org.practice.designPattern.struct.ch09facade.runoob.Circle;
import org.practice.designPattern.struct.ch09facade.runoob.Rectangle;
import org.practice.designPattern.struct.ch09facade.runoob.Shape;
import org.practice.designPattern.struct.ch09facade.runoob.Square;

public class ShapeMaker {

	private Shape circle;

	private Shape rectangle;

	private Shape square;

	public ShapeMaker() {
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
	}

	public void drawCircle() {
		circle.draw();
	}

	public void drawRectangle() {
		rectangle.draw();
	}

	public void drawSquare() {
		square.draw();
	}
}
