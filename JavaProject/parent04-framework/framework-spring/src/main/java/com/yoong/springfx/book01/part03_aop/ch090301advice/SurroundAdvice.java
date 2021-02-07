package com.yoong.springfx.book01.part03_aop.ch090301advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Desc 环绕通知(per-class类型)
 * PS：CGlib的 MethodInterceptor 接口：org.springframework.cglib.proxy.MethodInterceptor
 * SpringAOP的 MethodInterceptor 接口：org.aopalliance.intercept.MethodInterceptor
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
public class SurroundAdvice implements MethodInterceptor {

    /**
     * TODO: spring aop中MethodInterceptor接口的方法
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //前置横切逻辑
        Method method = invocation.getMethod();
        Object object = invocation.getThis();
        Object[] arguments = invocation.getArguments();
        //方法调用
        Object result = invocation.proceed();
        //后置横切逻辑
        System.out.println(result);
        return result;
    }

    /**
     * TODO: cglib中MethodInterceptor接口的方法
     */
//	@Override
//	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
//		System.out.println("SurroundAdvice.intercept");
//		return null;
//	}

}
