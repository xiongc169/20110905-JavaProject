package org.practice.designPattern.create.abstractFactory;

public class ShapeFactory implements AbstractFactory {

	/**
	 * @param shapeName
	 * @return
	 */
	public Shape produceShape(String shapeName) {
		Shape shape = null;
		switch (shapeName.toLowerCase()) {
		case "Shapeaa":
			shape = new ShapeAA();
			break;
		case "Shapebb":
			shape = new ShapeBB();
			break;
		}
		return shape;
	}
}
