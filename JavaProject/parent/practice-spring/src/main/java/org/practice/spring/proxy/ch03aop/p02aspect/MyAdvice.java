package org.practice.spring.proxy.ch03aop.p02aspect;

import org.aspectj.lang.JoinPoint;

/**
 * 通知
 */
public class MyAdvice {

    /**
     * 前置通知
     *
     * @param jp
     */
    public void before(JoinPoint jp) {
        System.out.println("MyAdvice.before" + jp);
    }

    /**
     * 后置通知
     *
     * @param jp
     */
    public void after(JoinPoint jp) {
        System.out.println("MyAdvice.after" + jp);
    }
}
