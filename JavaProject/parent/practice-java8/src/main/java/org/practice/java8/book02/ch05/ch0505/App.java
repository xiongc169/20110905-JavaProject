package org.practice.java8.book02.ch05.ch0505;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    /**
     * 入口函数
     *
     * @param agrs
     */
    public static void main(String[] agrs) {
        ch050501();

    }

    public static void ch050501() {
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
}
