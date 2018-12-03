package org.practice.java8.book02.ch04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
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
        List<String> names = menu.stream().map(Dish::getName).collect(Collectors.toList());
        System.out.println(names.size());

        DishType type = DishType.getType(1);
        System.out.println(type.getName());
    }
}
