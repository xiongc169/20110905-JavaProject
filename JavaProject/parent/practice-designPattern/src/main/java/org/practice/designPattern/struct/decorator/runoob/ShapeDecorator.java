package org.practice.designPattern.struct.decorator.runoob;

import org.practice.designPattern.struct.decorator.runoob.shape.Shape;

public abstract class ShapeDecorator implements Shape {

	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	public void draw() {
		decoratedShape.draw();
	}

}
