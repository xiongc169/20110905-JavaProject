package org.practice.java8.book01.ch02.predicate;

import org.practice.java8.book01.ch02.domain.Apple;

public class AppleGreenColorPredicate implements IApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equalsIgnoreCase("green");
    }

}
