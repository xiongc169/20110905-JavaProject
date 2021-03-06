package com.yoong.designPattern.create.ch02abstractFactory.runoob;

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
