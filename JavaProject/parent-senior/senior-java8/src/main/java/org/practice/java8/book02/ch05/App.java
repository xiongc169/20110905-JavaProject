package org.practice.java8.book02.ch05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Desc 《Java 8实战.pdf》
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018-03-02 09:00:00
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            reduceDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void reduceDemo() {
        List<Integer> result = Arrays.asList(1, 3, 5, 7, 9);
        //求和
        Integer sum = result.stream().reduce(0, (a, b) -> a + b);
        Integer sum2 = result.stream().reduce(0, Integer::sum);
        Optional<Integer> sum3 = result.stream().reduce((a, b) -> a + b);
        System.out.println(sum);
        System.out.println(sum2);
        System.out.println(sum3.get());
        //最大值和最小值
        Optional<Integer> max = result.stream().reduce((a, b) -> Math.max(a, b));
        Optional<Integer> max2 = result.stream().reduce(Math::max);
        System.out.println(max.get());
        Optional<Integer> min = result.stream().reduce((a, b) -> Math.min(a, b));
        System.out.println(min.get());
    }
}
