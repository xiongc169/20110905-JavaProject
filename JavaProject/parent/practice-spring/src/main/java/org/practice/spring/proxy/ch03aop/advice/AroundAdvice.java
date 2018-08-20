package org.practice.spring.proxy.ch03aop.advice;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author yoong
 *
 * @desc 环绕通知
 *
 * @date 2018年8月20日
 *
 */
public class AroundAdvice implements MethodInterceptor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.cglib.proxy.MethodInterceptor#intercept(java.lang.
	 * Object, java.lang.reflect.Method, java.lang.Object[],
	 * org.springframework.cglib.proxy.MethodProxy)
	 */
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

}
