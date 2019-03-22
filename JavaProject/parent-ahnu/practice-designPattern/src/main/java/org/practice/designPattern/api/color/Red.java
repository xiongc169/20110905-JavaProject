package org.practice.designPattern.api.color;

/**
 * @author yoong
 * <br>
 * @desc Red
 * <br>
 * @date 2019/1/14 15:06
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("this is Color-Red.fill() ");
    }
}
