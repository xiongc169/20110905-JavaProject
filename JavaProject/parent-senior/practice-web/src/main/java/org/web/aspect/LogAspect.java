package org.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author yoong
 * @desc LogAspect.java
 * @date 2018年8月20日
 */
@Aspect
@Component
public class LogAspect {

    public LogAspect() {
        System.out.println("LogAspect.LogAspect");
    }

    @Pointcut("execution(* *.login())")
    public void method() {
    }

    @Before(value = "method()")
    public void beforeAdvice(JoinPoint point) {
        System.out.println("LogAspect.beforeAdvice");
    }

    @After(value = "method()")
    public void afterAdvice(JoinPoint point) {
        System.out.println("LogAspect.afterAdvice");
    }

    @AfterReturning(value = "method()")
    public void afterReturningAdvice(JoinPoint point) {
        System.out.println("LogAspect.afterReturningAdvice");
    }

    @AfterThrowing(value = "method()")
    public void afterThrowingAdvice(JoinPoint point) {
        System.out.println("LogAspect.afterThrowingAdvice");
    }

    @Around(value = "method()")
    public void aroundAdvice(ProceedingJoinPoint pjp) {
        System.out.println("LogAspect.aroundAdvice");
        try {
            pjp.proceed();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
