package org.practice.designPattern.create.ch02abstractFactory.runoob;

import org.practice.designPattern.api.color.Color;
import org.practice.designPattern.api.shape.Shape;

public interface AbstractFactory {

    Shape getShape(String shapeType);

    Color getColor(String color);

}
