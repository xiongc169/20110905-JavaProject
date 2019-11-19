package org.practice.primary.book01.chap12.ttype;

import java.util.Map;

/**
 * @Desc TInterface
 * @Author
 * @Date
 * @Version 1.0
 */
public interface TInterface<T, U, S, K, V> {

    Map<K, V> genMap(T t, U u, S s);

    <R extends Comparable> Map<K, V> filter(T t, U u, S s, R r);
}
