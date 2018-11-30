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
     *
     * @param args
     */
    public static void main(String[] args) {

        //测试函数
        ch0701();
    }


    /**
     * 判断数字是质数 or 非质数
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

        menus.parallelStream().forEach(item -> System.out.println(item.getName()));

    }
}
