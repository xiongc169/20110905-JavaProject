package org.practice.designPattern.struct.ch07decorator;

import org.practice.designPattern.struct.ch07decorator.runoob.RedShapeDecorator;
import org.practice.designPattern.struct.ch07decorator.runoob.shape.Circle;
import org.practice.designPattern.struct.ch07decorator.runoob.shape.Rectangle;
import org.practice.designPattern.struct.ch07decorator.runoob.shape.Shape;

/**
 * 装饰者模式<br>
 * http://www.runoob.com/design-pattern/decorator-pattern.html
 *
 * @author Administrator
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {

        try {
            runoobTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void runoobTest() {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        circle.draw();
        redCircle.draw();
        redRectangle.draw();
    }

}
