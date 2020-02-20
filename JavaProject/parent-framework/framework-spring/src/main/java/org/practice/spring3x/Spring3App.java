package org.practice.spring3x;

import org.practice.spring.domain.Customer;
import org.practice.spring.domain2.Student;
import org.practice.spring3x.config.BeanConfig;
import org.practice.spring3x.config.JmsConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Desc Spring3App
 * @Author
 * @Date
 * @Version 1.0
 */
public class Spring3App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            springP030103();
            classLoader0302();
            annotationConfig0304();
            xmlRefJavaConfig();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Spring的p命名空间
     * PS：报错：通配符的匹配很全面, 但无法找到元素 'p:customerId' 的声明。
     * https://blog.csdn.net/cckevincyh/article/details/89741577
     */
    public static void springP030103() {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring3/spring-p.xml");
            Customer customer = (Customer) context.getBean("customer_01");
            System.out.println(customer.getCustomerId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void classLoader0302() {
        ClassLoader appClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(appClassLoader);
        ClassLoader extClassLoader = appClassLoader.getParent();
        System.out.println(extClassLoader);
        ClassLoader rootClassLoader = extClassLoader.getParent();
        System.out.println(rootClassLoader);
    }

    public static void annotationConfig0304() {
        ApplicationContext jmsConfig = new AnnotationConfigApplicationContext(JmsConfig.class);
        ApplicationContext beanConfig = new AnnotationConfigApplicationContext(BeanConfig.class);
        //Student student01 = (Student) jmsConfig.getBean("student");
        Student student02 = (Student) beanConfig.getBean("student");
        System.out.println(student02.getStudentId());
    }

    public static void xmlRefJavaConfig() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring3/spring-ref.xml");
        classPathXmlApplicationContext.start();
        Student student = (Student) classPathXmlApplicationContext.getBean("student");
        System.out.println(student.getStudentId());

        String[] beanDefinitionNames = classPathXmlApplicationContext.getBeanDefinitionNames();
        System.out.println(beanDefinitionNames.length);
    }
}
