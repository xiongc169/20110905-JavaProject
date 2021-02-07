package com.yoong.java8.book01.ch05;

import com.yoong.java8.book01.ch05.ch0505.Trader;
import com.yoong.java8.book01.ch05.ch0505.Transaction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Desc 《Java 8实战.pdf》
 * 第五章、使用流
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
            flatMap0502();
            reduce0504();
            trade0505();
            rawTypeStream0506();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void flatMap0502() {
        List<String> strList = new ArrayList<String>();
        strList.add("Hello");
        strList.add("World");

        List<String> parts01 = Arrays.asList("Hello".split(""));
        System.out.println(parts01.size());

        List<Integer> lengths = strList.stream().map(item -> item.length()).collect(Collectors.toList());//String::length
        System.out.println(lengths.size());

        List<String[]> parts = strList.stream().map(item -> item.split("")).collect(Collectors.toList());//String::length
        System.out.println(parts.size());
        List<String> parts02 = strList.stream().map(item -> item.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(parts02.size());
        List<String> parts04 = strList.stream().map(item -> item.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(parts04.size());
        List<String> parts03 = strList.stream().flatMap(item -> Arrays.stream(item.split(""))).distinct().collect(Collectors.toList());
        System.out.println(parts03.size());

    }

    public static void reduce0504() {
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

    public static void trade0505() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //5-1、过滤排序
        List<Transaction> sorted = transactions.stream().filter(item -> item.getYear() == 2011).sorted(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else if (o1.getValue() == o2.getValue()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }).collect(Collectors.toList());
        List<Transaction> sorted2 = transactions.stream().filter(item -> item.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(sorted.size());
        System.out.println(sorted2.size());
        //5-2、转换去重
        List<String> cities = transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(Collectors.toList());
        System.out.println(cities.size());
        //5-3、转换-过滤-去重-排序
        List<Trader> traders = transactions.stream().map(Transaction::getTrader).filter(item -> item.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println(traders.size());
        //5-3、转换-过滤-去重-排序
        List<String> names = transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct().sorted().collect(Collectors.toList());
        System.out.println(traders.size());
    }

    public static void rawTypeStream0506() {
        List<Integer> result = Arrays.asList(1, 3, 5, 7, 9);
        //求和
        Integer sum = result.stream().reduce(0, (a, b) -> a + b);
        //Integer sum02 = result.stream().mapToInt().sum();
    }
}
