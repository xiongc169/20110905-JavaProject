package com.yoong.java8.book01.ch02.predicate;

import com.yoong.java8.book01.ch02.domain.Apple;

public class AppleHeavyWeightPredicate implements IApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }

}
