package org.practice.spring.proxy.ch03aop.p03annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    public MyAspect() {
        System.out.println("MyAspect.MyAspect");
    }

    @Pointcut("execution(* org.practice.spring.proxy.ch01static.CalculatorImpl.add(..))")
    public void pointcutAdd() {
    }

    @Before("pointcutAdd()")
    public void before() {
        System.out.println("MyAspect.before");
    }
}
