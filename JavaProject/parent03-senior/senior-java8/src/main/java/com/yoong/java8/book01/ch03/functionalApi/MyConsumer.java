package com.yoong.java8.book01.ch03.functionalApi;

import java.util.function.Consumer;

public class MyConsumer implements Consumer {

    @Override
    public void accept(Object o) {

    }

    @Override
    public Consumer andThen(Consumer after) {
        return null;
    }
}
