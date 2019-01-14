package org.practice.designPattern.create.factory;

import org.practice.designPattern.create.factory.fruit.Fruit;
import org.practice.designPattern.create.factory.fruit.Orange;
import org.practice.designPattern.create.factory.fruit.Pear;
import org.practice.designPattern.create.factory.fruit.Strawberry;

/**
 * 工厂模式<br>
 * http://www.runoob.com/design-pattern/factory-pattern.html
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
