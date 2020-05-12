package org.practice.springfx.book01.part03_aop.ch03aop;

import org.practice.springfx.api.ISubject;
import org.practice.springfx.book01.part03_aop.ch01static.proxy.CalculatorImpl;
import org.practice.springfx.api.ICalculator;
import org.practice.springfx.book01.part03_aop.ch03aop.p01advice.AfterReturningAdvices;
import org.practice.springfx.book01.part03_aop.ch03aop.p01advice.AfterThrowAdvice;
import org.practice.springfx.book01.part03_aop.ch03aop.p01advice.BeforeAdvice;
import org.practice.springfx.book01.part03_aop.ch03aop.p01advice.SurroundAdvice;
import org.springframework.aop.framework.AopProxyFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc Spring学习总结（二）——静态代理、JDK与CGLIB动态代理、AOP+IoC
 * PS：切面(Aspect)、切入点(PointCut)、通知(Advice)、目标对象(Target)、连接点(JoinPoint)、织入(Weaver)、代理(Proxy)
 * 通知类型：前置通知、后置通知、环绕通知、异常通知、引介通知 <br>
 * spring aop的pointcut的表达式类型：execution、with等9种；
 * http://www.cnblogs.com/best/p/5679656.html
 * Spring AOP开发 XML配置、注解配置
 * https://blog.csdn.net/qq_35232663/article/details/79617270
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
public class AOPClient {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        //测试
        try {
            aop_proxyFactory090501();
            aop_proxyFactoryBean090502();
            aop_xml();
            aop_annotation();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 创建代理工厂、设置被代理对象、添加通知
     * PS：执行顺序1 Before -> Surround -> Impl -> Surround -> After
     * 执行顺序2 Before -> Surround -> Impl -> AfterThrow
     */
    public static void aop_proxyFactory090501() {
        //实例化Spring代理工厂
        ProxyFactory factory = new ProxyFactory();
        //设置被代理的对象
        factory.setTarget(new CalculatorImpl());
        //添加通知，横切逻辑
        factory.addAdvice(new BeforeAdvice());
        factory.addAdvice(new SurroundAdvice());
        factory.addAdvice(new AfterReturningAdvices());
        factory.addAdvice(new AfterThrowAdvice());
        //从代理工厂中获得代理对象
        ICalculator math = (ICalculator) factory.getProxy();
        int addResult = math.add(100, 5);
        //int subResult = math.sub(100, 5);
        //int mulResult = math.mul(100, 5);
        //double divResult = math.div(100, 5);
        System.out.println("addResult: " + addResult);
        //System.out.println("subResult: " + subResult);
        //System.out.println("mulResult: " + mulResult);
        //System.out.println("divResult: " + divResult);
    }

    /**
     * 使用IOC配置的方式实现AOP
     */
    public static void aop_proxyFactoryBean090502() {
        //XML配置方式实现AOP
        ApplicationContext cpxAppContext = new ClassPathXmlApplicationContext("classpath:book01/aop/spring-aop.xml");
        ICalculator math = (ICalculator) cpxAppContext.getBean("target");
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

        //ProxyFactoryBean ProxyFactoryBean02 = (ProxyFactoryBean) cpxAppContext.getBean("proxy");
        ICalculator calculator02 = (ICalculator) cpxAppContext.getBean("proxy");
        int result02 = calculator02.add(100, 50);
        System.out.println("result02: " + result02);
    }

    /**
     * 使用XML配置的方式实现Spring AOP的切面、切点、通知
     * <p/>
     * SpringAop时Null return value from advice does not match primitive return type for: public int...异常
     * https://blog.csdn.net/thewindkee/article/details/99437068
     */
    public static void aop_xml() {
        //XML配置方式实现AOP
        ApplicationContext cpxAppContext = new ClassPathXmlApplicationContext("classpath:book01/aop/spring-aop-xml.xml");
        ISubject subject = (ISubject) cpxAppContext.getBean("target");
        String result = subject.say("aop_aspect", 100);
        System.out.println("result: " + result);
    }

    /**
     * 注解方式实现AOP
     */
    public static void aop_annotation() {
        //注解方式实现AOP
        ApplicationContext cpxAppContext = new ClassPathXmlApplicationContext("classpath:book01/aop/spring-aop-anno.xml");
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
