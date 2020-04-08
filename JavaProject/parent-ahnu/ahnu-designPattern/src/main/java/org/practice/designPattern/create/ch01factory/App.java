package org.practice.designPattern.create.ch01factory;

import org.practice.designPattern.api.shape.Shape;
import org.practice.designPattern.api.fruit.Fruit;
import org.practice.designPattern.api.fruit.Orange;
import org.practice.designPattern.api.fruit.Pear;
import org.practice.designPattern.api.fruit.Strawberry;

/**
 * 工厂模式<br>
 * http://www.runoob.com/design-pattern/factory-pattern.html
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            factory_fruit();
            factory_runoob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void factory_fruit() {
        FruitFactory fFactory = new FruitFactory();
        Fruit orange = fFactory.produceFruit("Orange");
        orange.say();
        Fruit pear = fFactory.produceFruit("pear");
        pear.say();
        Fruit strawberry = fFactory.produceFruit("strawberry");
        strawberry.say();
        Fruit apple = fFactory.produceFruit("apple");
        apple.say();

        Fruit orange2 = (Fruit) fFactory.produceFruitByClass(Orange.class);
        orange2.say();
        Fruit pear2 = (Fruit) fFactory.produceFruitByClass(Pear.class);
        pear2.say();
        Fruit strawberry2 = (Fruit) fFactory.produceFruitByClass(Strawberry.class);
        strawberry2.say();
    }

    public static void factory_runoob() {
        ShapeFactory shapeFactory = new ShapeFactory();

        //获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape("SQUARE");
        //调用 Square 的 draw 方法
        shape3.draw();
    }
}
