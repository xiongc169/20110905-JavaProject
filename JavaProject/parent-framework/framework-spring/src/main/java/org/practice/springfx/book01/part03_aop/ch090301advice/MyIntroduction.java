package org.practice.springfx.book01.part03_aop.ch090301advice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;
/**
 * @Desc 引介通知(per-instance类型)
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
public class MyIntroduction implements IntroductionInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return null;
    }

    @Override
    public boolean implementsInterface(Class<?> intf) {
        return false;
    }
}
