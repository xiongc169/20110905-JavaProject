package org.practice.springfx.book01.part03_aop.ch03aop.p03annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Desc 切面
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
@Aspect
@Component
public class MyAspect {

    public MyAspect() {
        System.out.println("MyAspect.MyAspect");
    }

    @Pointcut("execution(* org.practice.springfx.book01.part03_aop.ch01static.proxy.CalculatorImpl.add(..))")
    public void pointcutAdd() {
    }

    @Before("pointcutAdd()")
    public void before() {
        System.out.println("MyAspect.before");
    }
}
