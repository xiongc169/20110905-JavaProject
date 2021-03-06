package com.yoong.designPattern.struct.ch07decorator;

import com.yoong.designPattern.api.shape.Circle;
import com.yoong.designPattern.api.shape.Rectangle;
import com.yoong.designPattern.api.shape.Shape;
import com.yoong.designPattern.struct.ch07decorator.runoob.RedShapeDecorator;

/**
 * @Desc 装饰者模式
 * http://www.runoob.com/design-pattern/decorator-pattern.html
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
            decorator_runoob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void decorator_runoob() {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        circle.draw();
        redCircle.draw();
        redRectangle.draw();
    }
}
