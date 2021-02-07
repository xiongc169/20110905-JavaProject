package com.yoong.designPattern.create.ch02abstractFactory.runoob;

import com.yoong.designPattern.api.color.Color;
import com.yoong.designPattern.api.shape.Shape;

public interface AbstractFactory {

    Shape getShape(String shapeType);

    Color getColor(String color);

}
