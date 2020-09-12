package org.practice.designPattern.create.ch01factory;

import org.practice.designPattern.api.fruit.Fruit;
import org.practice.designPattern.api.fruit.Orange;
import org.practice.designPattern.api.fruit.Pear;
import org.practice.designPattern.api.fruit.Strawberry;
import org.practice.designPattern.api.shape.Shape;

/**
 * @Desc 工厂模式
 * http://www.runoob.com/design-pattern/factory-pattern.html
 * https://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年7月4日
 * <p>
 * @Version 1.0
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

    /**
     * 普通工厂模式、多个工厂方法模式、静态工厂方法模式；
     */
    public static void factory_fruit() {
        FruitFactory fFactory = new FruitFactory();
        Fruit orange = fFactory.produceFruit("Orange");
        orange.say();
        Fruit pear = fFactory.produceFruit("pear");
        pear.say();
        Fruit strawberry = fFactory.produceFruit("strawberry");
        strawberry.say();
        Fruit apple = fFactory.produceFruit("apple");
        if (apple != null) {
            apple.say();
        }

        Fruit orange02 = fFactory.produceOrange();
        orange02.say();

        Fruit pear02 = FruitFactory.producePear();
        pear02.say();
        Fruit strawberry02 = FruitFactory.produceStrawberry();
        strawberry02.say();

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
