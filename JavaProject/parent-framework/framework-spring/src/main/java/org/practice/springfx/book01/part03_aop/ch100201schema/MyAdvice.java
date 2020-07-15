package org.practice.springfx.book01.part03_aop.ch100201schema;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Desc 通知
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
public class MyAdvice {

    /**
     * 前置通知
     */
    public void before(JoinPoint jp) {
        System.out.println("MyAdvice.before " + jp);
    }

    /**
     * 后置通知
     */
    public void afterFinally(JoinPoint jp) {
        System.out.println("MyAdvice.afterFinally " + jp);
    }

    /**
     * 返回通知
     */
    public void afterReturning(JoinPoint jp) {
        System.out.println("MyAdvice.afterReturning " + jp);
    }

    /**
     * 异常通知
     */
    public void afterThrowing(JoinPoint jp) {
        System.out.println("MyAdvice.afterThrowing " + jp);
    }

    /**
     * 环绕通知
     */
    public void surround(ProceedingJoinPoint jp) {
        try {
            System.out.println("MyAdvice.surround Before... " + jp);
            jp.proceed();
            System.out.println("MyAdvice.surround After " + jp);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
