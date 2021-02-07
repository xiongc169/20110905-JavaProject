package com.yoong.designPattern.struct.ch09facade;

import com.yoong.designPattern.struct.ch09facade.runoob.ShapeMaker;

/**
 * @Desc 外观模式
 * http://www.runoob.com/design-pattern/facade-pattern.html
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
            facade_runoob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void facade_runoob() {
        ShapeMaker maker = new ShapeMaker();
        maker.drawRectangle();
        maker.drawSquare();
        maker.drawCircle();
    }
}
