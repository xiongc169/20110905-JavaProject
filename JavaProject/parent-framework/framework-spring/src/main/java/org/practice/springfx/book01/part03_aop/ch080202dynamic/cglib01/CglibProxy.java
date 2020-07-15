package org.practice.springfx.book01.part03_aop.ch080202dynamic.cglib01;

import org.practice.springfx.book01.part03_aop.ch080201static.proxy.SubjectImpl;

/**
 * @Desc CGlib动态代理原理及实现 (MethodInterceptor + Enhancer)
 * PS：JDK实现动态代理需要实现类通过接口定义业务方法，对于没有接口的类，需要CGLib实现动态代理；
 * CGLib采用字节码技术，通过字节码技术为一个类创建一个子类，在子类中采用方法拦截技术拦截父类方法的调用，同时织入横切逻辑；
 * JDK动态代理与CGLib动态代理均是实现Spring AOP的基础；
 * CGLib创建的动态代理对象性能比JDK创建的动态代理对象的性能高不少，但是CGLib在创建代理对象时所花费的时间却比JDK多得多，所以对于单例的对象，因为无需频繁创建对象，用CGLib合适；
 * 反之，使用JDK方式要更为合适一些。同时，由于CGLib由于是采用动态创建子类的方法，对于final方法，无法进行代理。
 * http://blog.csdn.net/yakoo5/article/details/9099133/
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年8月20日
 * <p>
 * @Version 1.0
 */
public class CglibProxy {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //cglib动态代理
            cglibProxyTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * cglib动态代理
     */
    public static void cglibProxyTest() {
        try {
            MyMethodInterceptor myMethodInterceptor = new MyMethodInterceptor();
            SubjectImpl subject = (SubjectImpl) myMethodInterceptor.getProxy(SubjectImpl.class);
            subject.say("CglibProxy", 100);
        } catch (Exception ex) {
            String msg = ex.getMessage();
            System.out.println(msg);
        }
    }
}
