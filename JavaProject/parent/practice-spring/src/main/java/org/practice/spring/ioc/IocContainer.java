package org.practice.spring.ioc;

import org.practice.spring.domain.User;
import org.practice.spring.domain2.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.util.Iterator;
import java.util.Set;

/**
 * @author yoong
 * @desc Spring学习总结（一）——Spring实现IoC的多种方式
 * http://www.cnblogs.com/best/p/5727935.html
 * @date 2017年8月9日
 */
public class IocContainer {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        //测试
        try {
            beanFactoryDemo();
            resourceDemo();
            applicatioinDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * TODO: BeanFactory
     * <p>
     * 通过DefaultListableBeanFactory加载xml配置文件
     * https://www.aliyun.com/jiaocheng/809547.html
     */
    public static void beanFactoryDemo() {
        Resource resource = new ClassPathResource("spring-context.xml");
        BeanFactory xmlfactory = new XmlBeanFactory(resource);
        User user = (User) xmlfactory.getBean("user");
        User user2 = xmlfactory.getBean("user", User.class);
        System.out.println(user.getIid());
        System.out.println(user2.getIid());


        DefaultListableBeanFactory dlBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(dlBeanFactory);
        xmlReader.loadBeanDefinitions(resource);
        User user3 = (User) dlBeanFactory.getBean("user");
        System.out.println(user3.getIid());

        /**
         * 获取BeanDefinition，并注册到BeanDefinitionRegistry
         * BeanDefinition及其实现类
         * https://www.cnblogs.com/lupeng2010/p/7028742.html
         */
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(true);
        Set<BeanDefinition> definitionSet = provider.findCandidateComponents("org.practice.spring.domain2");
        System.out.println(definitionSet.size());
        Iterator iterator = definitionSet.iterator();
        while (iterator.hasNext()) {
            BeanDefinition beanDefinition = (BeanDefinition) iterator.next();
            ((XmlBeanFactory) xmlfactory).registerBeanDefinition("student", beanDefinition);
        }
        if (((XmlBeanFactory) xmlfactory).containsBeanDefinition("student")) {
            Student student = (Student) xmlfactory.getBean("student");
            System.out.println(student.getStudentId());
        }

        /**
         * 查看BeanDefinitionRegistry中注册的BeanDefinition
         * Spring BeanDefinitionRegistry
         * https://blog.csdn.net/chs007chs/article/details/78614332
         */
        String[] beanDefinitionNames = ((XmlBeanFactory) xmlfactory).getBeanDefinitionNames();
        System.out.println(beanDefinitionNames.length);
    }

    /**
     * TODO: Resource\ResourceLoader
     */
    public static void resourceDemo() {
        // Resource res = new ByteArrayResource();

        ResourceLoader resLoader = new DefaultResourceLoader();
        //XML文件不存在时，不会抛异常
        Resource res = resLoader.getResource("F:\\usr\\local\\yoong\\global.xml");
        System.out.println(res.exists());

        Resource res2 = resLoader.getResource("classpath:spring-context.xml");
        System.out.println(res2.exists());
    }

    /**
     * TODO: ApplicationContext
     * <p>
     * FileSystemXmlApplicationContext 路径
     * PS：静态方法中不可用
     * https://blog.csdn.net/judyfun/article/details/52210148
     * https://blog.csdn.net/qq_36951116/article/details/79133662
     * ClassPathXmlApplicationContext和FileSystemXmlApplicationContext路径问题
     * https://www.cnblogs.com/alisonGavin/p/6870056.html
     */
    public static void applicatioinDemo() {
        try {
            ApplicationContext fileSystemXmlPre = new FileSystemXmlApplicationContext();
            Resource resource = fileSystemXmlPre.getResource("");
            System.out.println(resource.exists());

            ApplicationContext fileSystemXml = new FileSystemXmlApplicationContext("JavaProject\\parent\\practice-spring\\src\\main\\resources\\spring-context.xml");
            User user = (User) fileSystemXml.getBean("user");
            System.out.println(user.getIid());
            ((FileSystemXmlApplicationContext) fileSystemXml).close();

            ApplicationContext classpathXml = new ClassPathXmlApplicationContext("spring-context.xml");
            User user2 = (User) classpathXml.getBean("user");
            System.out.println(user2.getIid());
            ((ClassPathXmlApplicationContext) classpathXml).close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

}
