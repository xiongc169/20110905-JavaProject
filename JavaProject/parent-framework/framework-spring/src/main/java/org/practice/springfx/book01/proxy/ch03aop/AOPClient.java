package org.practice.springfx.book01.proxy.ch03aop;

import org.practice.springfx.book01.proxy.ch01static.CalculatorImpl;
import org.practice.springfx.book01.proxy.api.ICalculator;
import org.practice.springfx.book01.proxy.ch03aop.p01advice.AfterAdvice;
import org.practice.springfx.book01.proxy.ch03aop.p01advice.BeforeAdvice;
import org.practice.springfx.book01.proxy.ch03aop.p01advice.SurroundAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yoong
 *
 * @desc Spring学习总结（二）——静态代理、JDK与CGLIB动态代理、AOP+IoC
 *      PS：切面(Aspect)、切入点(PointCut)、通知(Advice)、目标对象(Target)、连接点(JoinPoint)、织入(Weaver)、代理(Proxy)
 *      通知类型：前置通知、后置通知、环绕通知、异常通知、引介通知 <br>
 *      spring aop的pointcut的表达式类型：execution、with等9种；
 * <p>
 * http://www.cnblogs.com/best/p/5679656.html
 *
 * @date 2018年8月20日
 */
public class AOPClient {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        //测试
        try {
            aop_proxyFactory();
            reflectTest();
            aop_ioc();
            aop_aspect();
            aop_annotation();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 创建代理工厂、设置被代理对象、添加通知
     */
    public static void aop_proxyFactory() {
        //实例化Spring代理工厂
        ProxyFactory factory = new ProxyFactory();
        //设置被代理的对象
        factory.setTarget(new CalculatorImpl());
        //添加通知，横切逻辑
        factory.addAdvice(new BeforeAdvice());
        factory.addAdvice(new AfterAdvice());
        factory.addAdvice(new SurroundAdvice());
        //从代理工厂中获得代理对象
        ICalculator math = (ICalculator) factory.getProxy();
        int addResult = math.add(100, 5);
        int subResult = math.sub(100, 5);
        int mulResult = math.mul(100, 5);
        double divResult = math.div(100, 5);
        System.out.println("addResult: " + addResult);
        System.out.println("subResult: " + subResult);
        System.out.println("mulResult: " + mulResult);
        System.out.println("divResult: " + divResult);
    }

    /**
     * 反射
     */
    public static void reflectTest() {
        try {
            //通过反射创建对象
            ICalculator calculator = CalculatorImpl.class.newInstance();
            int result = calculator.add(100, 5);
            System.out.println("result: " + result);
            //Class<ICalculator> entityClass = (Class<ICalculator>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            //T entity = entityClass.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 使用IOC配置的方式实现AOP
     */
    public static void aop_ioc() {
        //XML配置方式实现AOP
        ApplicationContext cpxAppContext = new ClassPathXmlApplicationContext("classpath:aop/spring-aop.xml");
        ICalculator math = (ICalculator) cpxAppContext.getBean("ch08proxy");
        int addResult = math.add(100, 5);
        int subResult = math.sub(100, 5);
        int mulResult = math.mul(100, 5);
        double divResult = math.div(100, 5);
        System.out.println("addResult: " + addResult);
        System.out.println("subResult: " + subResult);
        System.out.println("mulResult: " + mulResult);
        System.out.println("divResult: " + divResult);

        //ProxyFactoryBean
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(new CalculatorImpl());
        proxyFactoryBean.addAdvice(new SurroundAdvice());
        ICalculator calculator = (ICalculator) proxyFactoryBean.getObject();
        int result = calculator.add(100, 50);
        System.out.println("result: " + result);
    }

    /**
     * 使用XML配置的方式实现Spring AOP的切面、切点、通知
     */
    public static void aop_aspect() {
        //XML配置方式实现AOP
        ApplicationContext cpxAppContext = new ClassPathXmlApplicationContext("classpath:aop/spring-aspect.xml");
        ICalculator math = (ICalculator) cpxAppContext.getBean("target");
        int addResult = math.add(100, 5);
        int subResult = math.sub(100, 5);
        int mulResult = math.mul(100, 5);
        double divResult = math.div(100, 5);
        System.out.println("addResult: " + addResult);
        System.out.println("subResult: " + subResult);
        System.out.println("mulResult: " + mulResult);
        System.out.println("divResult: " + divResult);
    }

    /**
     * 注解方式实现AOP
     */
    public static void aop_annotation() {
        //注解方式实现AOP
        ApplicationContext cpxAppContext = new ClassPathXmlApplicationContext("classpath:aop/spring-annotation.xml");
        ICalculator math = (ICalculator) cpxAppContext.getBean("target");
        int addResult = math.add(100, 5);
        int subResult = math.sub(100, 5);
        int mulResult = math.mul(100, 5);
        double divResult = math.div(100, 5);
        System.out.println("addResult: " + addResult);
        System.out.println("subResult: " + subResult);
        System.out.println("mulResult: " + mulResult);
        System.out.println("divResult: " + divResult);
    }
}
