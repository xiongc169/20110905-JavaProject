package org.practice.java8.book02.ch02Stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Desc 《写给大忙人看的JavaSE8》
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018-03-02 09:00:00
 * <p>
 * @Version 1.0
 */
public class StreamAPI {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            convert();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void convert() {
        double[] doubleArray = new double[]{1, 2, 3, 4, 5};
        Stream doubleStream = (Stream) Arrays.stream(doubleArray);
        Stream doubleStream2 = Stream.of(doubleArray);
    }
}
