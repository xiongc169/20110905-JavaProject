package com.yoong.designPattern.create.ch02abstractFactory.runoob;

import com.yoong.designPattern.api.shape.Circle;
import com.yoong.designPattern.api.shape.Rectangle;
import com.yoong.designPattern.api.shape.Shape;
import com.yoong.designPattern.api.shape.Square;
import com.yoong.designPattern.api.color.Color;

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
