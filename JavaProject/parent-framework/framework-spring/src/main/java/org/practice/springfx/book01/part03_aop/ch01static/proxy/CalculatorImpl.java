package org.practice.springfx.book01.part03_aop.ch01static.proxy;

import org.practice.springfx.api.ICalculator;

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
