package org.practice.designPattern.create.ch01factory;

import org.practice.designPattern.api.fruit.Fruit;
import org.practice.designPattern.api.fruit.Orange;
import org.practice.designPattern.api.fruit.Pear;
import org.practice.designPattern.api.fruit.Strawberry;

public class FruitFactory {

    /**
     * @desc 普通工厂模式
     */
    public Fruit produceFruit(String fruitName) {
        Fruit fruit = null;
        switch (fruitName.toLowerCase()) {
            case "orange":
                fruit = new Orange();
                break;
            case "pear":
                fruit = new Pear();
                break;
            case "strawberry":
                fruit = new Strawberry();
                break;
        }
        return fruit;
    }

    /**
     * @desc 多个工厂方法的工厂模式
     */
    public Fruit produceOrange() {
        Fruit fruit = new Orange();
        return fruit;
    }

    public Fruit producePear() {
        Fruit fruit = new Pear();
        return fruit;
    }

    public Fruit produceStrawberry() {
        Fruit fruit = new Strawberry();
        return fruit;
    }

    /**
     * Class.forName()、Class.forName().newInstance()、New 三者区别
     * https://www.cnblogs.com/shosky/archive/2011/07/22/2114290.html
     *
     * @param clazz
     *
     * @return
     */
    public Object produceFruitByClass(Class<? extends Fruit> clazz) {
        Object obj = null;

        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return obj;

    }
}
