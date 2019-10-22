package org.practice.spring.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc Spring中的aware接口
 * PS：BeanNameAware接口是为了让Bean自身能够感知到，获取到自身在Spring容器中的id属性；
 * 其他的Aware接口也是为了能够感知到自身的一些属性。比如实现了ApplicationContextAware接口的类，能够获取到ApplicationContext，实现了BeanFactoryAware接口的类，能够获取到BeanFactory对象。
 * https://www.jianshu.com/p/c5c61c31080b
 * spring aware 的个人理解
 * https://www.cnblogs.com/drafire/p/9273940.html
 * https://www.cnblogs.com/FraserYu/p/11211235.html
 * @Author
 * @Date
 * @Version 1.0
 */
public class App4Aware {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            awareTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void awareTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-aware.xml");
        XBeanName xBeanName = (XBeanName) context.getBean("xBeanName");
        XBeanNameAware xBeanNameAware = (XBeanNameAware) context.getBean("xBeanNameAware");
        XApplicationContextAware xApplicationContextAware = (XApplicationContextAware) context.getBean("xApplicationContextAware");

        System.out.println(xBeanName.getId());
        System.out.println(xBeanName.getBeanName());
        System.out.println(xBeanNameAware.getId());
        System.out.println(xBeanNameAware.getBeanName());
        System.out.println(xApplicationContextAware.getApplicationContext());
    }
}

