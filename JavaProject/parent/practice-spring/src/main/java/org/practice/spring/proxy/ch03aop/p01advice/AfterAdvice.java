package org.practice.spring.proxy.ch03aop.p01advice;

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
public class AfterAdvice implements AfterReturningAdvice {

	/**
	 * @param returnValue 返回值
	 * @param method      被调用的方法
	 * @param args        方法参数
	 * @param target      被代理对象
	 * @throws Throwable
	 */
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("AfterAdvice.afterReturning");
	}
}
