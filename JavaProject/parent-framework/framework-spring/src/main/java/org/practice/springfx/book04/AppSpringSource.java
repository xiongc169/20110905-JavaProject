package org.practice.springfx.book04;

import org.practice.springfx.domain.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
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
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:book04/spring-code.xml");
            Car car = (Car) applicationContext.getBean("car_01");
            System.out.println(car.getCarId());

            URL url = new URL("");
            Resource resource = new ClassPathResource("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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

}
