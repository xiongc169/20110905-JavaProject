package org.practice.springfx.book01.proxy.ch03aop.p01advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author yoong
 *
 * @desc 前置通知
 *
 * @date 2018年8月20日
 *
 */
public class BeforeAdvice implements MethodBeforeAdvice {

    /**
     * @param method 方法信息
     * @param args   参数
     * @param target 被代理的目标对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("BeforeAdvice.before");
    }
}
