package org.practice.java8.book02.ch03.functionalApi;

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
