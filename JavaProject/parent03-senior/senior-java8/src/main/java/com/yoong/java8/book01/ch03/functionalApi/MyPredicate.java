package com.yoong.java8.book01.ch03.functionalApi;

import java.util.function.Predicate;

public class MyPredicate implements Predicate<Object> {

	@Override
	public boolean test(Object t) {
		return false;
	}

}
