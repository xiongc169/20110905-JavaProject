package com.yoong.springfx.book01.part03_aop;

import com.yoong.springfx.api.ICalculator;
import com.yoong.springfx.api.impl.CalculatorImpl;
import com.yoong.springfx.book01.part03_aop.ch090301advice.AfterReturningAdvices;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @Desc Spring AOP详解
 * PS：Spring中AOP代理由Spring的IOC容器负责生成、管理，其依赖关系也由IOC容器负责管理。
 * http://www.cnblogs.com/hongwz/p/5764917.html
 * http://www.cnblogs.com/xrq730/p/4919025.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
public class AopContainerLite {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        //测试
        try {
            weaverTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * SpringAPI手动创建代理对象——ProxyFactory <br>
     * PS：配置多个通知时，前置通知正序执行，后置通知逆序执行，环绕通知前正、后逆。MethodInterceptor：方法拦截器可以实现MethodBeforeAdvice接口、AfterReturningAdvice接口、ThrowsAdvice三个接口所能够实现的效果
     * <br>
     * https://blog.csdn.net/u012834750/article/details/71773598
     */
    private static void weaverTest() {
        try {
            // 目标对象
            ICalculator calc = new CalculatorImpl();
            // 织入器
            ProxyFactory weaver = new ProxyFactory(calc);
            // 织入通知，前置通知
            weaver.addAdvice(new MethodBeforeAdvice() {
                @Override
                public void before(Method method, Object[] args, Object target) throws Throwable {
                    System.out.println("MethodBeforeAdvice.befor()");
                }
            });
            // 织入通知，后置通知
            weaver.addAdvice(new AfterReturningAdvices());
            // 代理对象
            ICalculator calcProxy = (ICalculator) weaver.getProxy();
            int result = calcProxy.add(12, 23);
            System.out.println(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
