package org.practice.designPattern.api.shape;

/**
 * @author yoong
 * <br>
 * @desc Square
 * <br>
 * @date 2019/1/15 17:09
 */
public class Square implements Shape {
    
    @Override
    public void draw() {
        System.out.println("Square::draw() ");
    }
}
