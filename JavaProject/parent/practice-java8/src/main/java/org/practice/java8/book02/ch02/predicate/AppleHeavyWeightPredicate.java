package org.practice.java8.book02.ch02.predicate;

import org.practice.java8.book02.ch02.domain.Apple;

public class AppleHeavyWeightPredicate implements IApplePredicate {

	@Override
	public boolean test(Apple apple) {

		return apple.getWeight() > 150;
	}

}
