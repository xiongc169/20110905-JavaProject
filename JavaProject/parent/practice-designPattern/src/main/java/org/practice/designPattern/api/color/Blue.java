package org.practice.designPattern.api.color;

/**
 * @author yoong
 * <br>
 * @desc Blue
 * <br>
 * @date 2019/1/14 15:06
 */
public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("this is Color-Blue.fill() ");
    }
}
