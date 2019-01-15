package org.practice.designPattern.create.ch02abstractFactory.color;

/**
 * @author yoong
 * <br>
 * @desc Green
 * <br>
 * @date 2019/1/14 15:06
 */
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("this is Color-Green");
    }
}
