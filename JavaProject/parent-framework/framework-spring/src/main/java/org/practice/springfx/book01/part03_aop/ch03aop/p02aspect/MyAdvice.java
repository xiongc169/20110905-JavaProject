package org.practice.springfx.book01.part03_aop.ch03aop.p02aspect;

import org.aspectj.lang.JoinPoint;

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
