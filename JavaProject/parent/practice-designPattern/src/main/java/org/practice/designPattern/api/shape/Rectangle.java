package org.practice.designPattern.api.shape;

/**
 * @author yoong
 * <br>
 * @desc Rectangle
 * <br>
 * @date 2019/1/15 17:09
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle::draw() ");
    }
}
