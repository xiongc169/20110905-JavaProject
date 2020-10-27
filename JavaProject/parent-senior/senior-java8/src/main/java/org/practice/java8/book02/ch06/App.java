package org.practice.java8.book02.ch06;

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
        ch0602();
        ch0603();
        ch0604();
    }

    /**
     * 6.2、归约和汇总
     */
    public static void ch0602() {
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

        Map<DishType, List<Dish>> groups = menus.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(groups.size());

        //6.2、归约和汇总
        Long count = menus.stream().collect(Collectors.counting());
        Long count2 = menus.stream().count();
        System.out.println(count);
        System.out.println(count2);

        //6.2.1、查找流中最大值和最小值
        Optional<Dish> max = menus.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        Optional<Dish> max2 = menus.stream().max(Comparator.comparing(Dish::getCalories));
        System.out.println(max);
        System.out.println(max2);

        //6.2.2、汇总
        Integer allCalories = menus.stream().collect(Collectors.summingInt(Dish::getCalories));
        IntSummaryStatistics summaryStatistics = menus.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(allCalories);
        System.out.println(summaryStatistics.getMax());

        //6.2.3、连接字符串
        String names = menus.stream().map(Dish::getName).collect(Collectors.joining(", "));
        String names2 = menus.stream().map(Dish::getName).reduce("", (a, b) -> a + ", " + b);
        System.out.println(names);
        System.out.println(names2);
    }

    /**
     * 6.3、分组
     */
    public static void ch0603() {
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

        //6.3、分组
        Map<DishType, List<Dish>> dishGroups = menus.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishGroups.size());

        Map<String, List<Dish>> dishGroups2 = menus.stream().collect(Collectors.groupingBy(groupByCalories()));
        System.out.println(dishGroups2.size());

        //6.3.1、多级分组
        Map<DishType, Map<Boolean, List<Dish>>> dishGroups3 = menus.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(Dish::isVegetarian)));
        System.out.println(dishGroups.size());

        //6.3.2、按子组收集数据
        Map<DishType, Long> caloriesGroups = menus.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.summingLong(Dish::getCalories)));
        System.out.println(caloriesGroups.size());

        //6.3.2.1、把收集器的结果转换为另一种类型
        Map<DishType, Optional<Dish>> maxCaloriesDish = menus.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparing(Dish::getCalories))));
        System.out.println(maxCaloriesDish.size());
        Map<DishType, Dish> maxCaloriesDish2 = menus.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
        System.out.println(maxCaloriesDish2.size());

        //6.3.2.2、与groupingBy联合使用的其他收集器的例子
        Map<DishType, Set<String>> maxCaloriesDish3 = menus.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(groupByCalories(), Collectors.toSet())));
        System.out.println(maxCaloriesDish3.size());
    }

    private static Function<Dish, String> groupByCalories() {
        return (dish) -> {
            String result = "";
            if (dish.getCalories() <= 400) {
                result = "Low";
            } else if (dish.getCalories() <= 700) {
                result = "Normal";
            } else if (dish.getCalories() <= 400) {
                result = "High";
            }
            return result;
        };
    }

    /**
     * 6.4、分区
     */
    public static void ch0604() {
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

        //6.4、分区
        Map<Boolean, List<Dish>> parts = menus.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(parts.size());
        System.out.println(parts.get(true).size());

    }

    /**
     * 判断数字是质数 or 非质数
     *
     * @return
     */
    private static Function<Integer, Boolean> isPrime() {
        return item -> {
            return IntStream.range(2, item).noneMatch(div -> item % div == 0);
        };
    }
}
