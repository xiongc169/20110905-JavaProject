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

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("AroundAdvice.intercept");
		return null;
	}

}
