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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.aop.AfterReturningAdvice#afterReturning(java.lang.
	 * Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub

	}

}
