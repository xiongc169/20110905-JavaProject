package org.practice.java8.book02.ch0502;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 20180112002
 *
 * @description StreamOperation.java
 *
 * @date 2018年5月3日
 *
 * @version 1.0
 *
 */
public class StreamOperation {

	public static void main(String[] args) {

		flatMapTest();

	}

	public static void flatMapTest() {
		List<String> hello = new ArrayList<String>();
		hello.add("Hello");
		hello.add("World");

//		hello.stream().map(item -> item.split("")).flatMap(Arrays::stream).distinct().forEach(item -> System.out.println(item));
		hello.stream().flatMap(item -> Arrays.stream(item.split(""))).distinct().forEach(item -> System.out.println(item));
		List<String> chara = hello.stream().map(item -> item.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
		System.out.println(chara.size());
	}

}
