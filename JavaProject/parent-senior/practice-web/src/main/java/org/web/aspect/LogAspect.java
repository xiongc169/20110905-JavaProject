package org.web.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author yoong
 *
 * @desc LogAspect.java
 *
 * @date 2018年8月20日
 *
 */
@Aspect
@Component
public class LogAspect {

	public LogAspect() {
		System.out.println("LogAspect.LogAspect");
	}

	@Pointcut("execution(* *.login())")
	public void method() {
	}

	@Before(value = "method()")
	public void beforeAdvice() {
		System.out.println("LogAspect.beforeAdvice");
	}

	@After(value = "method()")
	public void afterAdvice() {
		System.out.println("LogAspect.afterAdvice");
	}

	@AfterReturning(value = "method()")
	public void afterReturningAdvice() {
		System.out.println("LogAspect.afterReturningAdvice");
	}

	@AfterThrowing(value = "method()")
	public void afterThrowingAdvice() {
		System.out.println("LogAspect.afterThrowingAdvice");
	}

	@Around(value = "method()")
	public void aroundAdvice() {
		System.out.println("LogAspect.aroundAdvice");
	}
}
