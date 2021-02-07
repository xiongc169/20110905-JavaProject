package com.yoong.springfx.book01.part03_aop.ch080201static;

import com.yoong.springfx.api.ICalculator;
import com.yoong.springfx.book01.part03_aop.ch080201static.proxy.CalculatorProxy;

/**
 * @Desc StaticProxyApp
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年8月13日 下午2:27:36
 * <p>
 * @Version 1.0
 */
public class StaticProxyApp {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            // 静态代理测试
            staticProxy();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 静态代理 测试
     */
    public static void staticProxy() {
        ICalculator calcProxy = new CalculatorProxy();
        calcProxy.add(20, 10);
        calcProxy.sub(20, 10);
        calcProxy.mul(20, 10);
        calcProxy.div(20, 10);
    }
}
