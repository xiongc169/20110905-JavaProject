package org.practice.springfx.book01.part03_aop.ch090301advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * @Desc 后置通知(per-class类型)
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
public class AfterReturningAdvices implements AfterReturningAdvice {

    /**
     * @param returnValue 返回值
     * @param method      被调用的方法
     * @param args        方法参数
     * @param target      被代理对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AfterReturningAdvices.afterReturning");
    }
}
