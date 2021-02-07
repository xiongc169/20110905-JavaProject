package com.yoong.java8.book01.ch02;

import com.yoong.java8.book01.ch02.domain.Apple;
import com.yoong.java8.book01.ch02.predicate.AppleGreenColorPredicate;
import com.yoong.java8.book01.ch02.predicate.IApplePredicate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Desc 《Java 8实战.pdf》
 * 第一章、为什么要关心Java 8
 * 第二章、通过 行为参数化 传递代码
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018-03-02 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppBehaviorParameterization {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            sort0101();
            behaviorParameterization0202();
            anonymousClass0203();
            lambda0203();
            demo0204();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Chap 1、排序    P2
     */
    public static void sort0101() {
        List<Apple> appleList = new LinkedList<Apple>();
        Apple apple01 = new Apple("001", "red", 120);
        Apple apple02 = new Apple("002", "red", 130);
        Apple apple03 = new Apple("003", "blue", 110);
        Apple apple04 = new Apple("004", "green", 140);
        appleList.add(apple01);
        appleList.add(apple02);
        appleList.add(apple03);
        appleList.add(apple04);
        Comparable comparable = null;
        Comparator comparator = null;

        //Chap 1、匿名类-比较器    P2
        //Chap 3.7.2、使用匿名类
        Collections.sort(appleList, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        //Chap 1、方法引用    P2
        //Chap 3.6、方法引用  P53
        //Chap 3.7.4、使用方法引用
        appleList.sort(Comparator.comparing(Apple::getWeight));

        //Chap 2.4.1、匿名函数，用Comparator排序    P31
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        //Chap 2.4.1、Lambda表达式，用Comparator排序    P31
        //Chap 3.7.3、使用Lambda表达式
        appleList.sort((Apple a1, Apple a2) -> {
            return a1.getWeight().compareTo(a2.getWeight());
        });
        //Lambda表达式2
        appleList.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

        //排序
        List<Apple> sorted01 = appleList.stream().sorted(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        }).collect(Collectors.toList());

        //ch0101：排序3
        List<Apple> sorted02 = appleList.stream().sorted(Comparator.comparing(Apple::getWeight)).collect(Collectors.toList());
        System.out.println(sorted02.size());
    }

    /**
     * Chap 2.1、应对不断变化的需求   P21
     * Chap 2.2、行为参数化 —— Predicate  P23
     */
    public static void behaviorParameterization0202() {
        List<Apple> appleList = new LinkedList<Apple>();
        Apple apple01 = new Apple("001", "red", 120);
        Apple apple02 = new Apple("002", "red", 130);
        Apple apple03 = new Apple("003", "red", 110);
        appleList.add(apple01);
        appleList.add(apple02);
        appleList.add(apple03);

        // 行为参数化
        IApplePredicate predicate = new AppleGreenColorPredicate();
        List<Apple> appleList2 = filterApples(appleList, predicate);
        System.out.println(appleList2.size());
    }

    public static List<Apple> filterApples(List<Apple> appleList, IApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple item : appleList) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Chap 2.3、对付啰嗦
     * Chap 2.3.1、匿名类
     */
    public static void anonymousClass0203() {
        List<Apple> appleList = new LinkedList<Apple>();
        Apple apple01 = new Apple("001", "red", 120);
        Apple apple02 = new Apple("002", "red", 130);
        Apple apple03 = new Apple("003", "red", 110);
        appleList.add(apple01);
        appleList.add(apple02);
        appleList.add(apple03);

        //行为参数化：匿名类
        List<Apple> appleList2 = filterApples(appleList, new IApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 150;
            }
        });
        System.out.println(appleList2.size());
    }

    /**
     * Chap 2.3、对付啰嗦
     * Chap 2.3.3、使用Lambda表达式
     */
    public static void lambda0203() {
        List<Apple> appleList = new LinkedList<Apple>();
        Apple apple01 = new Apple("001", "red", 120);
        Apple apple02 = new Apple("002", "red", 130);
        Apple apple03 = new Apple("003", "red", 110);
        appleList.add(apple01);
        appleList.add(apple02);
        appleList.add(apple03);

        //行为参数化：Lambda表达式
        List<Apple> appleList3 = filterApples(appleList, (Apple item) -> item.getColor().equalsIgnoreCase("green"));
        System.out.println(appleList3.size());
    }

    /**
     * Chap 2.4、真实的例子
     * PS：匿名类、Lambda表达式
     */
    public static void demo0204() {
        Comparator comparator01 = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() > o2.getWeight() ? 1 : 0;
            }
        };
        Comparator comparator02 = (Object a1, Object a2) -> {
            return ((Apple) a1).getWeight() > ((Apple) a2).getWeight() ? 1 : 0;
        };
        Comparator comparator03 = (Object a1, Object a2) -> ((Apple) a1).getWeight() > ((Apple) a2).getWeight() ? 1 : 0;

        Runnable runnable01 = new Runnable() {
            @Override
            public void run() {

            }
        };
        Runnable runnable02 = () -> {
        };
    }
}
