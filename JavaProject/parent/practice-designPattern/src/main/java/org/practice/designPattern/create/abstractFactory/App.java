package org.practice.designPattern.create.abstractFactory;

import org.practice.designPattern.create.abstractFactory.color.Red;

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
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            AbstractFactory abstractFactory = FactoryProducer.getFactory("color");
            Red red = (Red) abstractFactory.getColor("red");
            red.fill();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
