package org.practice.junior.book01.chap12.ch1202;

import java.util.Map;

public interface TInterface<T, U, S, K, V> {

    Map<K, V> genMap(T t, U u, S s);

    <R extends Comparable> Map<K, V> filter(T t, U u, S s, R r);
}
