package org.practice.spring.proxy;

import org.practice.spring.proxy.ch01static.CalculatorProxy;

/**
 * @author yoong
 * @desc
 * @date 2016年8月13日 下午2:27:36
 */
public class ProxyApp {

    /**
     * 入口函数
     *
     * @description
     */
    public static void main(String[] args) {
        // 静态代理测试
        staticProxy();

    }

    /**
     * 静态代理 测试
     */
    public static void staticProxy() {
        CalculatorProxy calcProxy = new CalculatorProxy();
        calcProxy.add(20, 10);
    }
}
