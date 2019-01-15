package org.practice.designPattern.create.ch02abstractFactory.color;

import org.practice.designPattern.create.ch02abstractFactory.AbstractFactory;
import org.practice.designPattern.create.ch02abstractFactory.shape.Shape;

/**
 * @author yoong
 * <br>
 * @desc ColorFactory
 * <br>
 * @date 2019/1/14 15:07
 */
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
        }
        return null;
    }
}
