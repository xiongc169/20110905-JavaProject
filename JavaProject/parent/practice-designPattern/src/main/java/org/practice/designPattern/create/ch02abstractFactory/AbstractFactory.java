package org.practice.designPattern.create.ch02abstractFactory;

import org.practice.designPattern.create.ch02abstractFactory.color.Color;
import org.practice.designPattern.create.ch02abstractFactory.shape.Shape;

public interface AbstractFactory {

    Shape getShape(String shapeType);

    Color getColor(String color);

}
