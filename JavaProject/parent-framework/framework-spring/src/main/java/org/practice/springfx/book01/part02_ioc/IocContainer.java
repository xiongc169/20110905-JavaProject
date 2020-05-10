package org.practice.springfx.book01.part02_ioc;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.fastinfoset.CommonResourceBundle;
import org.practice.springfx.book01.part02_ioc.aware.XApplicationContextAware;
import org.practice.springfx.book01.part02_ioc.aware.XBeanName;
import org.practice.springfx.book01.part02_ioc.aware.XBeanNameAware;
import org.practice.springfx.domain.Car;
import org.practice.springfx.domain.Customer;
import org.practice.springfx.domain.User;
import org.practice.springfx.domain.Student;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.util.*;

/**
 * @Desc 《Spring揭秘》第二部分、Spring的IoC容器
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017-5-10 22:10:00
 * <p>
 * @Version 1.0
 */
public class IocContainer {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            injectDemo0202();
            beanFactoryDemo0401();
            applicationContextDemo0401();
            getBeanDefinitionAndRegister0402();
            beanFactoryPostProcessor040402();
            wrapperDemo040403();
            awareDemo040403();
            beanPostProcessor040403();
            resourceDemo0501();
            i18nDemo0502();
            annotationDemo0601();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * TODO: 2.2、三种依赖注入方式 (P11)
     * PS: 三种依赖注入方式：构造方法注入、setter方法注入、接口注入；
     * 3.2、IoC Service Provider如何管理对象间的依赖关系：直接编码方式、配置文件方式(*.properties|*.xml)、元数据方式；(P17)
     * 4.2、BeanFactory的对象注册、依赖绑定的方式：直接编码方式、外部配置文件方式(*.properties|*.xml)、注解方式；(P24)
     * <p>
     * Spring学习总结（一）——Spring实现IoC的多种方式
     * PS：注入方式：构造方法注入、setter方法注入；
     * IoC的配置方式：XML配置、注解配置；
     * http://www.cnblogs.com/best/p/5727935.html
     */
    public static void injectDemo0202() {
        Resource resource = new ClassPathResource("book01/ioc/spring-context.xml");
        BeanFactory xmlFactory = new XmlBeanFactory(resource);
        //2.2.1、构造方法注入
        Customer customer = (Customer) xmlFactory.getBean("customer_01");
        Customer customer2 = xmlFactory.getBean("customer_02", Customer.class);
        System.out.println(customer.getCustomerId());
        if (customer.getCar() != null) {
            System.out.println("customer.car = " + JSON.toJSONString(customer.getCar()));
        }
        System.out.println(customer2.getCustomerId());
        if (customer2.getCar() != null) {
            System.out.println("customer2.car = " + JSON.toJSONString(customer2.getCar()));
        }
        //2.2.2、setter方法注入
        User user = (User) xmlFactory.getBean("user_01");
        User user2 = xmlFactory.getBean("user_01", User.class);
        System.out.println(user.getIid());
        System.out.println(user2.getIid());
    }

    /**
     * TODO: 4.1、BeanFactory (P22)
     * PS: BeanFactory实现类：XmlBeanFactory、DefaultListableBeanFactory；
     * ApplicationContext实现类：ClassPathXmlApplicationContext、FileSystemXmlApplicationContext；
     * <p>
     * 通过DefaultListableBeanFactory加载xml配置文件
     * https://blog.csdn.net/weixin_33721344/article/details/91652199
     */
    public static void beanFactoryDemo0401() {
        //XmlBeanFactory
        Resource resource = new ClassPathResource("book01/ioc/spring-context.xml");
        BeanFactory xmlFactory = new XmlBeanFactory(resource);
        User user = (User) xmlFactory.getBean("user_01");
        User user2 = xmlFactory.getBean("user_02", User.class);
        System.out.println(user.getIid());
        System.out.println(user2.getIid());
        //若bean的scope=ch03singleton，则相等，若scope=prototype，则不等
        String compareResult = user == user2 ? "Equals" : "Not Equals";
        System.out.println(compareResult);

        //DefaultListableBeanFactory
        DefaultListableBeanFactory dlBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(dlBeanFactory);
        xmlReader.loadBeanDefinitions(resource);
        User user3 = (User) dlBeanFactory.getBean("user_01");
        System.out.println(user3.getIid());
    }

    /**
     * TODO: 4.1、ApplicationContext (P22)
     * PS: BeanFactory实现类：XmlBeanFactory、DefaultListableBeanFactory；
     * ApplicationContext实现类：ClassPathXmlApplicationContext、FileSystemXmlApplicationContext；
     * <p>
     * ClassPathXmlApplicationContext和FileSystemXmlApplicationContext路径问题
     * https://www.cnblogs.com/alisonGavin/p/6870056.html
     * <p>
     * FileSystemXmlApplicationContext 路径
     * PS：静态方法中不可用
     * https://blog.csdn.net/judyfun/article/details/52210148
     * https://blog.csdn.net/qq_36951116/article/details/79133662
     */
    public static void applicationContextDemo0401() {
        try {
            ApplicationContext fileSystemXmlPre = new FileSystemXmlApplicationContext();//new String[]{"", ""}
            Resource resource = fileSystemXmlPre.getResource("http://www.baidu.com");
            System.out.println(String.format("%s  %s", resource.exists(), resource.getClass()));

            //系统属性
            String directory = System.getProperty("user.dir");
            System.out.println(directory);

            //FileSystemXmlApplicationContext
            ApplicationContext fileSystemXml = new FileSystemXmlApplicationContext("JavaProject\\parent-framework\\framework-spring\\src\\main\\resources\\ioc\\spring-context.xml");
            User user = (User) fileSystemXml.getBean("user_01");
            System.out.println(user.getIid());
            ((FileSystemXmlApplicationContext) fileSystemXml).close();

            //ClassPathXmlApplicationContext
            ApplicationContext classpathXml = new ClassPathXmlApplicationContext("book01/ioc/spring-context.xml");
            User user2 = (User) classpathXml.getBean("user_02");
            System.out.println(user2.getIid());

            //查看容器中注册的BeanDefinition
            //https://blog.csdn.net/chengjunhua19890809/article/details/77981839
            String[] beanDefinitionNames = classpathXml.getBeanDefinitionNames();
            System.out.println(beanDefinitionNames.length);

            Customer customer11 = (Customer) classpathXml.getBean("customer_01");
            Customer customer12 = (Customer) classpathXml.getBean("customer_01");
            System.out.println(customer11 == customer12);
            Customer customer21 = (Customer) classpathXml.getBean("customer_02");
            Customer customer22 = (Customer) classpathXml.getBean("customer_02");
            System.out.println(customer21 == customer22);

            ((ClassPathXmlApplicationContext) classpathXml).close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * TODO: 4.2、BeanFactory的对象注册与依赖绑定 (P24)
     * PS: BeanFactory的对象注册、依赖绑定的方式：直接编码方式、外部配置文件方式(*.properties|*.xml)、注解方式；(P24)
     * 读取配置文件BeanDefinitionReader、获取BeanDefinition、注册到BeanDefinitionRegistry、实例化；
     * BeanDefinitionReader：PropertiesBeanDefinitionReader、XmlBeanDefinitionReader；
     * <p>
     * 获取BeanDefinition，并注册到BeanDefinitionRegistry
     * PS：BeanDefinition及其实现类
     * https://www.cnblogs.com/lupeng2010/p/7028742.html
     * <p>
     * 查看BeanDefinitionRegistry中注册的BeanDefinition
     * Spring BeanDefinitionRegistry
     * https://blog.csdn.net/chs007chs/article/details/78614332
     */
    public static void getBeanDefinitionAndRegister0402() {
        Resource resource = new ClassPathResource("book01/ioc/spring-context.xml");
        BeanFactory xmlFactory = new XmlBeanFactory(resource);
        //获取BeanDefinition，并注册
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(true);
        Set<BeanDefinition> definitionSet = provider.findCandidateComponents("org.practice.spring.domain2");
        System.out.println(definitionSet.size());
        Iterator iterator = definitionSet.iterator();
        while (iterator.hasNext()) {
            BeanDefinition beanDefinition = (BeanDefinition) iterator.next();
            ((XmlBeanFactory) xmlFactory).registerBeanDefinition("student", beanDefinition);
        }
        if (((XmlBeanFactory) xmlFactory).containsBeanDefinition("student")) {
            Student student = (Student) xmlFactory.getBean("student");
            System.out.println(student.getStudentId());
        }
        //查看BeanDefinitionRegistry中注册的BeanDefinition
        String[] beanDefinitionNames = ((XmlBeanFactory) xmlFactory).getBeanDefinitionNames();
        System.out.println(beanDefinitionNames.length);
    }

    /**
     * TODO: 4.4.2、插手容器的启动 (P66)
     * 代码4-41、4-42 BeanFactoryPostProcessor————PropertyPlaceholderConfigurer、PropertyOverrideConfigurer、CustomEditorConfigurer(略)
     */
    public static void beanFactoryPostProcessor040402() {
        //初始化BeanFactory
        Resource resource = new ClassPathResource("book01/ioc/spring-context.xml");
        ConfigurableListableBeanFactory clBeanFactory = new XmlBeanFactory(resource);
        User user = (User) clBeanFactory.getBean("user_02");
        System.out.println(user.getIid());

        //初始化BeanFactory + BeanFactoryPostProcessor
        Resource properties = new ClassPathResource("book01/ioc/config.properties");
        PropertyPlaceholderConfigurer ppConfigurer = new PropertyPlaceholderConfigurer();
        ppConfigurer.setLocation(properties);
        ppConfigurer.postProcessBeanFactory(clBeanFactory);//装配无效
        User user2 = (User) clBeanFactory.getBean("user_02");
        System.out.println(user2.getIid());

        //ApplicationContext
        ApplicationContext classpathXml = new ClassPathXmlApplicationContext("book01/ioc/spring-context.xml");
        User user3 = (User) classpathXml.getBean("user_02");
        User user4 = classpathXml.getBean("user_02", User.class);
        System.out.println(user3.getIid());
        System.out.println(user4.getIid());

        //PropertyPlaceholderConfigurer不仅从配置文件(*.properties)中加载配置项，还回检查System.Properties
    }

    /**
     * TODO: 4.4.3、了解bean的一生 (P73)
     * <p>
     * Spring中的 BeanWrapper
     * PS：BeanWrapper 是Spring提供的一个用来操作javaBean属性的工具，使用它可以直接修改一个对象的属性。
     * https://www.cnblogs.com/myadmin/p/7634702.html
     * Spring源码分析-BeanWrapper
     * https://blog.csdn.net/shenchaohao12321/article/details/80326142
     * Spring容器技术内幕之BeanWrapper类介绍
     * https://www.cnblogs.com/xiao2/p/7711850.html
     */
    public static void wrapperDemo040403() {
        Car car = new Car();
        //通过PropertyAccessorFactory将user对象封装成BeanWrapper
        BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(car);
        //方式一：直接对属性值进行设置
        wrapper.setPropertyValue("carId", "carId-01");
        //方式二：通过PropertyValue进行设置
        PropertyValue pv = new PropertyValue("carBrandName", "carBrandName-01");
        wrapper.setPropertyValue(pv);
        System.out.println(car.toString());
    }

    /**
     * TODO: 4.4.3、了解bean的一生 (P75)
     * <p>
     * Spring中的aware接口
     * PS：BeanNameAware接口是为了让Bean自身能够感知到，获取到自身在Spring容器中的id属性；
     * 其他的Aware接口也是为了能够感知到自身的一些属性。比如实现了ApplicationContextAware接口的类，能够获取到ApplicationContext，实现了BeanFactoryAware接口的类，能够获取到BeanFactory对象。
     * https://www.jianshu.com/p/c5c61c31080b
     * spring aware 的个人理解
     * https://www.cnblogs.com/drafire/p/9273940.html
     * https://www.cnblogs.com/FraserYu/p/11211235.html
     */
    public static void awareDemo040403() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:book01/ioc/spring-aware.xml");
        XBeanName xBeanName = (XBeanName) context.getBean("xBeanName");
        XBeanNameAware xBeanNameAware = (XBeanNameAware) context.getBean("xBeanNameAware");
        XApplicationContextAware xApplicationContextAware = (XApplicationContextAware) context.getBean("xApplicationContextAware");

        System.out.println(xBeanName.getId());
        System.out.println(xBeanName.getBeanName());
        System.out.println(xBeanNameAware.getId());
        System.out.println(xBeanNameAware.getBeanName());
        System.out.println(xApplicationContextAware.getApplicationContext());
    }

    /**
     * TODO: 4.4.3、了解bean的一生 (P76)
     * <p>
     */
    public static void beanPostProcessor040403() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:book01/ioc/spring-postprocessor.xml");
        Customer customer = (Customer) classPathXmlApplicationContext.getBean("customer_01");
        System.out.println(customer);
    }

    /**
     * TODO: 5.1、统一资源加载策略 (P84)
     * Resource: ByteArrayResource、ClassPathResource、FileSystemResource、UrlResource、InputStreamResource;
     * ResourceLoader: DefaultResourceLoader、FileSystemResourceLoader;
     * ResourcePatternResolver:
     * ApplicationContext:
     */
    public static void resourceDemo0501() throws Exception {
        //Resource
        byte[] bytes = new byte[1024];
        Resource byteArrayResource = new ByteArrayResource(bytes);
        Resource classPathResource = new ClassPathResource("");
        Resource fileSystemResource = new FileSystemResource("");
        Resource urlResource = new UrlResource("http://www.baidu.com");
        //Resource inputStreamResource = new InputStreamResource();
        System.out.println(String.format("%s  %s", byteArrayResource.exists(), byteArrayResource.getClass()));
        System.out.println(String.format("%s  %s", classPathResource.exists(), classPathResource.getClass()));
        System.out.println(String.format("%s  %s", fileSystemResource.exists(), fileSystemResource.getClass()));
        System.out.println(String.format("%s  %s", urlResource.exists(), urlResource.getClass()));
        System.out.println();

        //ResourceLoader
        ResourceLoader defaultLoader = new DefaultResourceLoader();
        ResourceLoader fileLoader = new FileSystemResourceLoader();
        //XML文件不存在时，不会抛异常
        Resource res = defaultLoader.getResource("file:D:\\Apache\\zkui\\config.cfg");
        Resource res2 = defaultLoader.getResource("classpath:ioc/spring-context.xml");
        Resource res3 = defaultLoader.getResource("http://www.baidu.com");
        System.out.println(String.format("%s  %s", res.exists(), res.getClass()));
        System.out.println(String.format("%s  %s", res2.exists(), res2.getClass()));
        System.out.println(String.format("%s  %s", res3.exists(), res3.getClass()));
        System.out.println();

        //ResourcePatternResolver
        ResourcePatternResolver defaultResolver = new PathMatchingResourcePatternResolver();
        ResourcePatternResolver fileResolver = new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());
        Resource res4 = defaultResolver.getResource("http://www.baidu.com");
        Resource[] res5 = defaultResolver.getResources("http://www.baidu.com");
        System.out.println(String.format("%s  %s", res4.exists(), res4.getClass()));
        System.out.println(String.format("%s  %s", res5.length, res5.getClass()));
        System.out.println();
    }

    /**
     * TODO: 5.2、国际化信息支持 (P95)
     */
    public static void i18nDemo0502() {
        Locale locale = Locale.CHINA;
        Locale locale2 = new Locale("zh");
        Locale locale3 = new Locale("zh", "CN");
        System.out.println();

        ResourceBundle bundle = CommonResourceBundle.getBundle("");
    }

    /**
     * TODO: 6.1、基于注解的依赖注入 (P110)
     */
    public static void annotationDemo0601() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:book01/ioc/spring-anno.xml");
        List<String> names = Arrays.asList(context.getBeanDefinitionNames());
        System.out.println(names.size());
        System.out.println(JSON.toJSONString(names));

        Customer customer = (Customer) context.getBean("customer_01");
        System.out.println(customer.getCustomerId());

        //UserServiceImpl service = (UserServiceImpl) context.getBean("userServiceImpl");
        //String userInfo = service.getUserInfo();
        //System.out.println(userInfo);
    }
}
