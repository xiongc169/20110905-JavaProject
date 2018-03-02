package org.practice.primary.proxyDynamic.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 使用Spring实现AOP
 * http://www.cnblogs.com/best/p/5679656.html
 * @author Administrator
 *
 */
public class BeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		
	}

}
