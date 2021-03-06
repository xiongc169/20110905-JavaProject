package com.yoong.java8.book01.ch04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Desc 《Java 8实战.pdf》
 * 第四章、引入流
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018-03-02 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppStream {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            stream0401();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void stream0401() {
        //初始化菜单
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, DishType.MEAT),
                new Dish("beef", false, 700, DishType.MEAT),
                new Dish("chicken", false, 400, DishType.MEAT),
                new Dish("french fries", true, 530, DishType.OTHER),
                new Dish("rice", true, 350, DishType.OTHER),
                new Dish("season fruit", true, 120, DishType.OTHER),
                new Dish("pizza", true, 550, DishType.OTHER),
                new Dish("prawns", false, 300, DishType.FISH),
                new Dish("salmon", false, 450, DishType.FISH));

        menu.stream().forEach(item -> System.out.println(item.getName()));
        List<String> names = menu.stream().filter(item -> item.getCalories() < 500).sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName).collect(Collectors.toList());
        System.out.println(names.size());

        DishType type = DishType.getType(1);
        System.out.println(type.getName());
    }
}
