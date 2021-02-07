package com.yoong.designPattern.struct.ch09facade.runoob;

import com.yoong.designPattern.api.shape.Circle;
import com.yoong.designPattern.api.shape.Rectangle;
import com.yoong.designPattern.api.shape.Shape;
import com.yoong.designPattern.api.shape.Square;

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
