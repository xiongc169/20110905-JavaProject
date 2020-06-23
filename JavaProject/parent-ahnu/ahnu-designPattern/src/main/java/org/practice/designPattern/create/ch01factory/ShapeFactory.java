package org.practice.designPattern.create.ch01factory;

import org.practice.designPattern.api.shape.Circle;
import org.practice.designPattern.api.shape.Rectangle;
import org.practice.designPattern.api.shape.Shape;
import org.practice.designPattern.api.shape.Square;

/**
 * 工厂模式
 * http://www.runoob.com/design-pattern/factory-pattern.html
 */
public class ShapeFactory {

    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
