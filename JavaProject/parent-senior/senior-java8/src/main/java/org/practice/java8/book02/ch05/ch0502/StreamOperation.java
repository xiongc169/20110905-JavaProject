package org.practice.java8.book02.ch05.ch0502;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Desc 《Java 8实战.pdf》
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018-03-02 09:00:00
 * <p>
 * @Version 1.0
 */
public class StreamOperation {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            flatMapTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void flatMapTest() {
        List<String> hello = new ArrayList<String>();
        hello.add("Hello");
        hello.add("World");

        List<String> parts = Arrays.asList("Hello".split(""));
        System.out.println(parts.size());

        List<Integer> lengths = hello.stream().map(item -> item.length()).collect(Collectors.toList());//String::length
        System.out.println(lengths.size());

        hello.stream().map(item -> item.split("")).flatMap(Arrays::stream).distinct().forEach(item -> System.out.println(item));
        System.out.println("Test");

        hello.stream().flatMap(item -> Arrays.stream(item.split(""))).distinct().forEach(item -> System.out.println(item));
        System.out.println("Test");

        List<String> chara = hello.stream().map(item -> item.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(chara.size());
    }
}
