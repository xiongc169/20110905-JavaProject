package com.yoong.junior.book01.chap12.impl;

import com.yoong.junior.book01.chap12.ch1202.TInterface;

import java.util.Map;

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
