package org.practice.springfx.book01.proxy;

import org.practice.springfx.book01.proxy.ch01static.CalculatorProxy;

/**
 * @author yoong
 *
 * @desc
 *
 * @date 2016年8月13日 下午2:27:36
 */
public class ProxyApp {

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
        CalculatorProxy calcProxy = new CalculatorProxy();
        calcProxy.add(20, 10);
    }
}
