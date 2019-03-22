package org.practice.designPattern.create.ch02abstractFactory.runoob;

import org.practice.designPattern.api.shape.Circle;
import org.practice.designPattern.api.shape.Rectangle;
import org.practice.designPattern.api.shape.Shape;
import org.practice.designPattern.api.shape.Square;
import org.practice.designPattern.api.color.Color;

public class ShapeFactory implements AbstractFactory {

    @Override
    public Shape getShape(String shapeName) {
        Shape shape = null;
        switch (shapeName.toLowerCase()) {
            case "circle":
                shape = new Circle();
                break;
            case "rectangle":
                shape = new Rectangle();
                break;
            case "square":
                shape = new Square();
                break;
        }
        return shape;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
