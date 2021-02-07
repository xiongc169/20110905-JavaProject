package com.yoong.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc LogAspect.java
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
@Aspect
@Component
public class LogAspect {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public LogAspect() {
        System.out.println("LogAspect.LogAspect");
    }

    /**
     * Spring Aop中execution的语法
     * https://blog.csdn.net/mianyao1004/article/details/93656829
     */
    @Pointcut("execution(* *.login(..))")
    public void method() {
    }

    @Before(value = "method()")
    public void beforeAdvice(JoinPoint point) {
        System.out.println(format.format(new Date()) + ": LogAspect.beforeAdvice");
    }

    @After(value = "method()")
    public void afterAdvice(JoinPoint point) {
        System.out.println(format.format(new Date()) + ": LogAspect.afterAdvice");
    }

    @AfterReturning(value = "method()")
    public void afterReturningAdvice(JoinPoint point) {
        System.out.println(format.format(new Date()) + ": LogAspect.afterReturningAdvice");
    }

    @AfterThrowing(value = "method()")
    public void afterThrowingAdvice(JoinPoint point) {
        System.out.println(format.format(new Date()) + ": LogAspect.afterThrowingAdvice");
    }

    @Around(value = "method()")
    public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(format.format(new Date()) + ": 进入LogAspect.aroundAdvice");
        try {
            pjp.proceed();
            System.out.println(format.format(new Date()) + ": 退出LogAspect.aroundAdvice");
        } catch (Throwable ex) {
            //ex.printStackTrace();// 若不抛出异常，则不会进入 afterThrowingAdvice 通知
            throw ex;//异常需要抛出，否则不会进入 afterThrowingAdvice 通知
        }
    }
}
