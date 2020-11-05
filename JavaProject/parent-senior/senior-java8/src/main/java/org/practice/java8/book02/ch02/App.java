package org.practice.java8.book02.ch02;

import java.util.*;
import java.util.stream.Collectors;

import org.practice.java8.book02.ch02.domain.Apple;
import org.practice.java8.book02.ch02.predicate.AppleGreenColorPredicate;
import org.practice.java8.book02.ch02.predicate.IApplePredicate;

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
            ch01();
            ch0202();
            ch0203();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 排序
     */
    public static void ch01() {
        List<Apple> appleList = new LinkedList<Apple>();
        Apple apple01 = new Apple("001", "red", 120);
        Apple apple02 = new Apple("002", "red", 130);
        appleList.add(apple01);
        appleList.add(apple02);

        //ch0101：排序1
        Collections.sort(appleList, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        //ch0204、用Comparator排序
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
        //ch0101：排序2
        appleList.sort(Comparator.comparing(Apple::getWeight));
        //排序
        appleList = appleList.stream().sorted(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        }).collect(Collectors.toList());
        //ch0101：排序3
        List<Apple> sorted2 = appleList.stream().sorted(Comparator.comparing(Apple::getWeight)).collect(Collectors.toList());
        System.out.println(sorted2.size());
    }

    /**
     * 行为参数化
     */
    public static void ch0202() {
        List<Apple> appleList = new LinkedList<Apple>();
        Apple apple01 = new Apple("001", "red", 120);
        Apple apple02 = new Apple("002", "red", 130);
        Apple apple03 = new Apple("003", "red", 110);
        appleList.add(apple01);
        appleList.add(apple02);
        appleList.add(apple03);

        // 行为参数化
        IApplePredicate predicate = new AppleGreenColorPredicate();
        List<Apple> appleList2 = behaviorParameter(appleList, predicate);
        System.out.println(appleList2.size());
    }

    /**
     * 行为参数化
     */
    public static List<Apple> behaviorParameter(List<Apple> appleList, IApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple item : appleList) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * 行为参数化
     */
    public static void ch0203() {
        List<Apple> appleList = new LinkedList<Apple>();
        Apple apple01 = new Apple("001", "red", 120);
        Apple apple02 = new Apple("002", "red", 130);
        Apple apple03 = new Apple("003", "red", 110);
        appleList.add(apple01);
        appleList.add(apple02);
        appleList.add(apple03);

        // 行为参数化：匿名类
        List<Apple> appleList2 = behaviorParameter(appleList, new IApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 150;
            }
        });
        // 行为参数化：Lambda表达式
        List<Apple> appleList3 = behaviorParameter(appleList, (Apple item) -> item.getColor().equalsIgnoreCase("green"));
        System.out.println(appleList2.size());
        System.out.println(appleList3.size());
    }
}
