package org.practice.springfx.book01.part03_aop;

import org.practice.springfx.api.ISubject;
import org.practice.springfx.api.impl.CalculatorImpl;
import org.practice.springfx.api.ICalculator;
import org.practice.springfx.book01.part03_aop.ch090301advice.AfterReturningAdvices;
import org.practice.springfx.book01.part03_aop.ch090301advice.AfterThrowAdvice;
import org.practice.springfx.book01.part03_aop.ch090301advice.BeforeAdvice;
import org.practice.springfx.book01.part03_aop.ch090301advice.SurroundAdvice;
import org.practice.springfx.book01.part03_aop.ch100101aspectj.MyAspect;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
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
public class AopContainer {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //测试
//            proxyFactory090501();
//            proxyFactoryBean090503();
//            autoCreatorProxy090504();

//            aspectj1001();
            schema1002();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * TODO: 9.5.1、如何与ProxyFactory打交道
     * 使用ProxyFactory通过编程创建AOP代理
     * https://www.php.cn/manual/view/21807.html
     * Spring之AOP流程解析(ProxyFactory)
     * https://www.cnblogs.com/letsfly/p/10660488.html
     * <p>
     * PS：创建代理工厂、设置被代理对象、添加通知
     * 执行顺序1: Before -> Surround -> Impl -> AfterReturning -> Surround
     * 执行顺序2: Before -> Surround -> Impl -> AfterThrow
     * 第一代Spring AOP，没有 AfterFinally 通知
     */
    public static void proxyFactory090501() {
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
     * TODO: 9.5.3、容器中的织入器——ProxyFactoryBean
     * 使用ProxyFactoryBean创建AOP代理
     * https://www.php.cn/manual/view/21799.html
     * 使用ProxyFactoryBean进行AOP
     * https://www.cnblogs.com/yjc1605961523/p/11759028.html
     * 使用IOC配置的方式实现AOP
     */
    public static void proxyFactoryBean090503() {
        //XML配置方式实现AOP
        ApplicationContext cpxAppContext = new ClassPathXmlApplicationContext("classpath:book01/aop/spring0905-proxyfactorybean.xml");
        ICalculator math = (ICalculator) cpxAppContext.getBean("target");
        int addResult = math.add(100, 5);
        int subResult = math.sub(100, 5);
        int mulResult = math.mul(100, 5);
        double divResult = math.div(100, 5);
        System.out.println("addResult: " + addResult);
        System.out.println("subResult: " + subResult);
        System.out.println("mulResult: " + mulResult);
        System.out.println("divResult: " + divResult);

        //硬编码方式使用 ProxyFactoryBean
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(new CalculatorImpl());
        proxyFactoryBean.addAdvice(new SurroundAdvice());
        ICalculator calculator = (ICalculator) proxyFactoryBean.getObject();
        int result = calculator.add(100, 50);
        System.out.println("result: " + result);

        //XML配置方式使用 ProxyFactoryBean
        ICalculator calculator02 = (ICalculator) cpxAppContext.getBean("proxy");
        int result02 = calculator02.add(100, 50);
        System.out.println("result02: " + result02);
        ProxyFactoryBean proxyFactoryBean02 = (ProxyFactoryBean) cpxAppContext.getBean("&proxy");
        System.out.println(proxyFactoryBean02);
    }

    /**
     * TODO: 9.5.4、加快织入的自动化进程
     * PS：BeanNameAutoProxyCreator、DefaultAdvisorAutoProxyCreator
     */
    public static void autoCreatorProxy090504() {
        ApplicationContext cpxAppContext = new ClassPathXmlApplicationContext("classpath:book01/aop/spring0905-beannameAutoproxycreator.xml");
        ICalculator math = (ICalculator) cpxAppContext.getBean("calculatorImpl");
        int addResult = math.add(100, 5);
        int subResult = math.sub(100, 5);
        int mulResult = math.mul(100, 5);
        double divResult = math.div(100, 5);
        System.out.println("addResult: " + addResult);
        System.out.println("subResult: " + subResult);
        System.out.println("mulResult: " + mulResult);
        System.out.println("divResult: " + divResult);

        ApplicationContext cpxAppContext02 = new ClassPathXmlApplicationContext("classpath:book01/aop/spring0905-defaultadvisorAutoproxycreator.xml");
        ICalculator math02 = (ICalculator) cpxAppContext02.getBean("calculatorImpl");
        int addResult02 = math02.add(100, 5);
        int subResult02 = math02.sub(100, 5);
        int mulResult02 = math02.mul(100, 5);
        double divResult02 = math02.div(100, 5);
        System.out.println("addResult02: " + addResult02);
        System.out.println("subResult02: " + subResult02);
        System.out.println("mulResult02: " + mulResult02);
        System.out.println("divResult02: " + divResult02);
    }

    /**
     * TODO: 10.1、@AspectJ形式的Spring AOP
     * 定义方式：通过注解定义AspectJ、Advice
     * 注入方式：编程方式织入、自动代理织入
     */
    public static void aspectj1001() {
        //1、编程方式织入
        AspectJProxyFactory weaver = new AspectJProxyFactory();
        weaver.setProxyTargetClass(true);
        weaver.setTarget(new CalculatorImpl());
        weaver.addAspect(MyAspect.class);
        CalculatorImpl calculator = weaver.getProxy();
        int addResult = calculator.add(100, 5);
        System.out.println("addResult: " + addResult);

        //2、通过自动代理织入 注解方式实现AOP
        ApplicationContext cpxAppContext = new ClassPathXmlApplicationContext("classpath:book01/aop/spring1001-aspectj.xml");
        ICalculator math = (ICalculator) cpxAppContext.getBean("calculator");
        int addResult02 = math.add(100, 5);
        int subResult02 = math.sub(100, 5);
        int mulResult02 = math.mul(100, 5);
        double divResult02 = math.div(100, 5);
        System.out.println("addResult02: " + addResult02);
        System.out.println("subResult02: " + subResult02);
        System.out.println("mulResult02: " + mulResult02);
        System.out.println("divResult02: " + divResult02);
    }

    /**
     * TODO: 10.2、基于Schema的AOP
     * 使用XML配置的方式实现Spring AOP的切面、切点、通知
     * <p/>
     * SpringAop时Null return value from advice does not match primitive return type for: public int...异常
     * https://blog.csdn.net/thewindkee/article/details/99437068
     */
    public static void schema1002() {
        //XML配置方式实现AOP
        ApplicationContext cpxAppContext = new ClassPathXmlApplicationContext("classpath:book01/aop/spring1002-xml.xml");
        ISubject subject = (ISubject) cpxAppContext.getBean("target");
        String result = subject.say("aop_aspect", 100);
        System.out.println("result: " + result);
    }
}
