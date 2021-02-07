package com.yoong.designPattern.create.ch02abstractFactory.runoob;

import com.yoong.designPattern.api.color.Blue;
import com.yoong.designPattern.api.color.Color;
import com.yoong.designPattern.api.color.Green;
import com.yoong.designPattern.api.color.Red;
import com.yoong.designPattern.api.shape.Shape;

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
