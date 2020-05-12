package org.practice.springfx.book01.part03_aop.ch03aop.p03annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.springframework.core.Ordered;
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
public class MyAspect implements Ordered {

    public MyAspect() {
        System.out.println("MyAspect.MyAspect");
    }

    @Pointcut("execution(* org.practice.springfx.book01.part03_aop.ch01static.proxy.CalculatorImpl.add(..))")
    public void pointcutAdd() {
    }

    @Before("pointcutAdd()")
    public void before(JoinPoint jp) {
        Object[] args = jp.getArgs();
        System.out.println("MyAspect.before");
    }

    @AfterReturning("pointcutAdd()")
    public void afterReturning(JoinPoint jp) {
        System.out.println("MyAspect.afterReturning");
    }

    @AfterThrowing("pointcutAdd()")
    public void afterThrowing(JoinPoint jp) {
        System.out.println("MyAspect.afterThrowing");
    }

    @After("pointcutAdd()")
    public void after(JoinPoint jp) {
        System.out.println("MyAspect.after");
    }

    @Around("pointcutAdd()")
    public void around(ProceedingJoinPoint pjp) {
        try {
            System.out.println("MyAspect.around Start...");
            pjp.proceed();
            System.out.println("MyAspect.around End");
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    /**
     * chap10.1.4、Advice执行顺序
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
