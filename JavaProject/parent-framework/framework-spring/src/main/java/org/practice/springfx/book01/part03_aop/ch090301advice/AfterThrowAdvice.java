package org.practice.springfx.book01.part03_aop.ch090301advice;

import org.springframework.aop.ThrowsAdvice;

/**
 * @Desc 后置通知(per-class类型)
 * [Spring]纯Java方式实现AOP拦截-详解ThrowsAdvice异常通知
 * https://blog.csdn.net/qq_26525215/article/details/52420658
 * 异常日志处理-ThrowsAdvice
 * https://www.cnblogs.com/sjcq/p/7450192.html
 * https://blog.csdn.net/qq1723205668/article/details/55667063
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
public class AfterThrowAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception ex) {
        System.out.println("AfterThrowAdvice.afterThrowing()");
    }
}
