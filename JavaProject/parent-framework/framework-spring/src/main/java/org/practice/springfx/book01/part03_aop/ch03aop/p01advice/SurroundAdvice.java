package org.practice.springfx.book01.part03_aop.ch03aop.p01advice;

import java.lang.reflect.Method;

//import org.springframework.cglib.ch08proxy.MethodInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Desc 环绕通知
 * TODO: 注意：SpringAop、cglib两个类库中都有MethodInterceptor接口
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
     *
     * @param invocation
     * @return
     * @throws Throwable
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
        //System.out.println(result);
        return result;
    }

    /**
     * TODO: cglib中MethodInterceptor接口的方法
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @return
     * @throws Throwable
     */
//	@Override
//	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
//		System.out.println("SurroundAdvice.intercept");
//		return null;
//	}

}
