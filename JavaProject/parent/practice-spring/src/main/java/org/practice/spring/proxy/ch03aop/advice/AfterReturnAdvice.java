package org.practice.spring.proxy.ch03aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * @author yoong
 *
 * @desc 后置通知
 *
 * @date 2018年8月20日
 *
 */
public class AfterReturnAdvice implements AfterReturningAdvice {
	
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("AfterReturnAdvice.afterReturning");
	}
}
