package org.practice.primary.book01.chap12.impl;

import org.practice.primary.book01.chap12.ch1202.TInterface;

import java.util.Map;

/**
 * @Desc TInterfaceImpl
 * @Author
 * @Date
 * @Version 1.0
 */
public class TInterfaceImpl implements TInterface<String, Integer, Integer, String, Double> {

    @Override
    public Map<String, Double> genMap(String s, Integer integer, Integer integer2) {
        return null;
    }

    @Override
    public <R extends Comparable> Map<String, Double> filter(String s, Integer integer, Integer integer2, R r) {
        return null;
    }
}
