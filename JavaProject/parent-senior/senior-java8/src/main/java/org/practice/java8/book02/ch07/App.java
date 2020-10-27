package org.practice.java8.book02.ch07;

import org.practice.java8.book02.ch04.Dish;
import org.practice.java8.book02.ch04.DishType;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {

        //测试函数
        sum(100);
        ch0701();
    }

    /**
     * 顺序流、并行流输出
     *
     * @return
     */
    private static void ch0701() {
        //初始化菜单
        List<Dish> menus = Arrays.asList(
                new Dish("pork", false, 800, DishType.MEAT),
                new Dish("beef", false, 700, DishType.MEAT),
                new Dish("chicken", false, 400, DishType.MEAT),
                new Dish("french fries", true, 530, DishType.OTHER),
                new Dish("rice", true, 350, DishType.OTHER),
                new Dish("season fruit", true, 120, DishType.OTHER),
                new Dish("pizza", true, 550, DishType.OTHER),
                new Dish("prawns", false, 300, DishType.FISH),
                new Dish("salmon", false, 450, DishType.FISH));

        menus.stream().forEach(item -> System.out.print(item.getName() + "  "));
        System.out.println();
        menus.parallelStream().forEach(item -> System.out.print(item.getName() + "  "));
        System.out.println();
    }

    /**
     * 求和
     *
     * @param n
     */
    private static void sum(Integer n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);

        int sum2 = IntStream.iterate(1, i -> i + 1).limit(n).parallel().reduce(0, (a, b) -> a + b);
        System.out.println(sum2);

        Integer processor = Runtime.getRuntime().availableProcessors();
        System.out.println(processor);
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "6");
    }
}
