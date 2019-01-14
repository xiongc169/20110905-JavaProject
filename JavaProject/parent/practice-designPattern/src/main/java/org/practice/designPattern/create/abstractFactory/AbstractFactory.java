package org.practice.designPattern.create.abstractFactory;

import org.practice.designPattern.create.abstractFactory.color.Color;
import org.practice.designPattern.create.abstractFactory.shape.Shape;

public interface AbstractFactory {

    Shape getShape(String shapeType);

    Color getColor(String color);

}
