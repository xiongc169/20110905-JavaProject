package org.practice.springfx.book01.proxy.ch01static;

import org.practice.springfx.book01.proxy.api.ICalculator;

/**
 * @author yoong
 * @description CalculatorImpl
 * @date 2016年8月13日 下午2:26:34
 */
public class CalculatorImpl implements ICalculator {

    public int add(int i, int j) {
        int result = i + j;
        System.out.println("CalculatorImpl.add result is " + result);
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
