package org.practice.designPattern.create.ch02abstractFactory.runoob;

import org.practice.designPattern.create.ch02abstractFactory.runoob.AbstractFactory;
import org.practice.designPattern.create.ch02abstractFactory.runoob.ColorFactory;
import org.practice.designPattern.create.ch02abstractFactory.runoob.ShapeFactory;

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
