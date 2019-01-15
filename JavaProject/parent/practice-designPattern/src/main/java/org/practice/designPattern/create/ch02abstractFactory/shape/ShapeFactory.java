package org.practice.designPattern.create.ch02abstractFactory.shape;

import org.practice.designPattern.create.ch02abstractFactory.AbstractFactory;
import org.practice.designPattern.create.ch02abstractFactory.color.Color;

public class ShapeFactory implements AbstractFactory {

    @Override
    public Shape getShape(String shapeName) {
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

    @Override
    public Color getColor(String color) {
        return null;
    }
}
