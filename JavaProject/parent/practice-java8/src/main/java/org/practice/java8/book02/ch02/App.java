package org.practice.java8.book02.ch02;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.practice.java8.book02.ch02.domain.Apple;
import org.practice.java8.book02.ch02.predicate.AppleGreenColorPredicate;
import org.practice.java8.book02.ch02.predicate.IApplePredicate;

public class App {

	public static void main(String[] args) {

		List<Apple> appleList = new LinkedList<Apple>();
		Apple apple01 = new Apple("001", "red", 120);
		Apple apple02 = new Apple("002", "red", 130);
		Apple apple03 = new Apple("003", "red", 110);
		Apple apple04 = new Apple("004", "red", 150);
		Apple apple05 = new Apple("005", "red", 100);
		appleList.add(apple01);
		appleList.add(apple02);
		appleList.add(apple03);
		appleList.add(apple04);
		appleList.add(apple05);

		// 行为参数化
		IApplePredicate predicate = new AppleGreenColorPredicate();
		// behaviorParameter(appleList, predicate);
		// behaviorParameter(appleList, (Apple item) ->
		// item.getColor().equalsIgnoreCase("green"));

		// appleList.forEach(item -> System.out.printf("%s - ", item.getId()));
		// 2.4.1、用Comparator排序
		appleList.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight().compareTo(a2.getWeight());
			}
		});
		appleList.forEach(item -> System.out.printf("%s - ", item.getId()));

	}

	/**
	 * 行为参数化
	 * 
	 * @param appleList
	 * @param predicate
	 */
	public static void behaviorParameter(List<Apple> appleList, IApplePredicate predicate) {
		for (Apple item : appleList) {
			if (predicate.test(item)) {
				System.out.println(item.getId());
			}
		}
	}

	public static void compare() {
	}

}
