package org.practice.java8.book02.ch05.ch0502;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 20180112002
 * @version 1.0
 * @description StreamOperation.java
 * @date 2018年5月3日
 */
public class StreamOperation {

    public static void main(String[] args) {

        flatMapTest();
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
