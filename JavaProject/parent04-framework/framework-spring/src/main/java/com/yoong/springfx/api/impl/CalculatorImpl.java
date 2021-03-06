package com.yoong.springfx.api.impl;

import com.yoong.springfx.api.ICalculator;

/**
 * @Desc CalculatorImpl
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年8月13日 下午2:26:34
 * <p>
 * @Version 1.0
 */
public class CalculatorImpl implements ICalculator {

    public int add(int i, int j) {
        int result = i + j;
        System.out.println("CalculatorImpl.add result is " + result);
        //double a = 1 / 0;
        return result;
    }

    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("CalculatorImpl.sub result is " + result);
        return result;
    }

    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("CalculatorImpl.mul result is " + result);
        return result;
    }

    public double div(int i, int j) {
        int result = i / j;
        System.out.println("CalculatorImpl.div result is " + result);
        return result;
    }
}
