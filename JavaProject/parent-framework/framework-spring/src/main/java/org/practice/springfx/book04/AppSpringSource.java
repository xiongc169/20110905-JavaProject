package org.practice.springfx.book04;

import org.practice.springfx.domain.Car;
import org.practice.springfx.domain.CustomTag;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.util.PropertyPlaceholderHelper;

import java.net.URL;

import static java.lang.System.getProperty;

/**
 * @Desc 《Spring源码深度解析》郝佳著
 * PS：2013年9月印刷；
 * 备注：2009年12月Spring3.0发布，2013年12月Spring4.0发布；2017年9月Spring5.0发布；
 * https://www.jb51.net/books/333610.html
 * 《Spring源码深度解析(第2版)》郝佳著
 * PS：2019年1月印刷；
 * http://yun.java1234.com/article/1822	！！！！！
 * https://www.aibooks.cc/book/biancheng	！！！！！
 * <p>
 * @Author yoong
 * <p>
 * @Date 2020年4月29日20:26:30
 * <p>
 * @Version 1.0
 */
public class AppSpringSource {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //junior0201();
            //core020402();
            //xmlBeanFactory0205();
            //customTag0401();
            applicationContext0601();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 2.1、容器的基本用法
     */
    public static void junior0201() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:book04/spring0201-core.xml");
        Car car = (Car) applicationContext.getBean("car_01");
        System.out.println(car.getCarId());
    }

    /**
     * 2.4.2、核心类介绍
     */
    public static void core020402() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(null);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(xmlBeanFactory);
    }

    /**
     * 2.5、容器的基础XmlBeanFactory
     */
    public static void xmlBeanFactory0205() throws Exception {
        InputStreamResource inputStreamResource = null;
        Resource resource = null;

        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("book04/spring0201-core.xml"));
        Car car = (Car) beanFactory.getBean("car_01");
        System.out.println(car.getCarId());

        //InputStream inputStream = AppSpringSource.class.getResourceAsStream("book04/spring0201-core.xml");
        //System.out.println(inputStream.available());
    }

    /**
     * 4.1、自定义标签使用
     */
    public static void customTag0401() throws Exception {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("book04/spring0401-custom.xml"));
        CustomTag user = (CustomTag) beanFactory.getBean("userId_01");
        System.out.println(user.getId());
    }

    /**
     * 6.1、设置配置路径
     */
    public static void applicationContext0601() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:book04/spring0201-core.xml");
        Car car = (Car) applicationContext.getBean("car_01");
        System.out.println(car.getCarId());
    }

    /**
     * AbstractPropertyResolver.resolveRequiredPlaceholders() L138
     */
    public static void placeholderResolverDemo() {
        PropertyPlaceholderHelper.PlaceholderResolver placeholderResolver = new PropertyPlaceholderHelper.PlaceholderResolver() {
            @Override
            public String resolvePlaceholder(String placeholderName) {
                System.out.println("PlaceholderResolver.resolvePlaceholder()");
                String property = getProperty(placeholderName);
                return property;
            }
        };
        String systemDir = placeholderResolver.resolvePlaceholder("user.dir");
        System.out.println(systemDir);
    }

    public static void other() throws Exception {
        URL url = new URL("");
        Resource resource = new ClassPathResource("");
    }
}
