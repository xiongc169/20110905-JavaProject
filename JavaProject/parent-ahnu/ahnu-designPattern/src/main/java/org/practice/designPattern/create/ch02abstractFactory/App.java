package org.practice.designPattern.create.ch02abstractFactory;

import org.practice.designPattern.api.color.Red;
import org.practice.designPattern.api.shape.Shape;
import org.practice.designPattern.create.ch02abstractFactory.runoob.AbstractFactory;
import org.practice.designPattern.create.ch02abstractFactory.runoob.FactoryProducer;

/**
 * @author yoong
 * <br>
 * @desc 抽象工厂模式<br>
 * http://www.runoob.com/design-pattern/abstract-factory-pattern.html
 * <br>
 * @date 2019/1/14 15:15
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
