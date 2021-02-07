package com.yoong.designPattern.create.ch02abstractFactory;

import com.yoong.designPattern.create.ch02abstractFactory.runoob.AbstractFactory;
import com.yoong.designPattern.create.ch02abstractFactory.runoob.FactoryProducer;
import com.yoong.designPattern.api.color.Red;
import com.yoong.designPattern.api.shape.Shape;

/**
 * @Desc 抽象工厂模式
 * http://www.runoob.com/design-pattern/abstract-factory-pattern.html
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
            abstractFactory_runoob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void abstractFactory_runoob() {
        AbstractFactory abstractFactory = FactoryProducer.getFactory("color");
        Red red = (Red) abstractFactory.getColor("red");
        red.fill();

        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape circle = shapeFactory.getShape("circle");
        circle.draw();
    }
}
