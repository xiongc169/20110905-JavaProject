package org.practice.designPattern.struct.ch09facade;

import org.practice.designPattern.api.shape.Circle;
import org.practice.designPattern.api.shape.Rectangle;
import org.practice.designPattern.api.shape.Shape;
import org.practice.designPattern.api.shape.Square;

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
