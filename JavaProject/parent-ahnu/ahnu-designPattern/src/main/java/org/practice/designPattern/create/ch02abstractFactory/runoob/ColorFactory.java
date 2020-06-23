package org.practice.designPattern.create.ch02abstractFactory.runoob;

import org.practice.designPattern.api.color.Blue;
import org.practice.designPattern.api.color.Color;
import org.practice.designPattern.api.color.Green;
import org.practice.designPattern.api.color.Red;
import org.practice.designPattern.api.shape.Shape;

public class ColorFactory implements AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }
}
