package org.practice.designPattern.create.ch02abstractFactory;

import org.practice.designPattern.create.ch02abstractFactory.color.ColorFactory;
import org.practice.designPattern.create.ch02abstractFactory.shape.ShapeFactory;

/**
 * @author Administrator
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String factoryName) {
        AbstractFactory factory = null;
        switch (factoryName.toLowerCase()) {
            case "shape":
                factory = new ShapeFactory();
                break;
            case "color":
                factory = new ColorFactory();
                break;
        }
        return factory;
    }
}
