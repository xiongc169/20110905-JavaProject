package org.practice.spring.proxy.ch03aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author yoong
 * 
 * @desc 前置通知
 *
 * @date 2018年8月20日
 *
 */
public class BeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub

	}

}
