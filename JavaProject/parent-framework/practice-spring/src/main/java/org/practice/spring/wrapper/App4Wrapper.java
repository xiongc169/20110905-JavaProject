package org.practice.spring.wrapper;

import org.practice.spring.domain.Car;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;

/**
 * @Desc Spring中的 BeanWrapper
 * PS：BeanWrapper 是Spring提供的一个用来操作javaBean属性的工具，使用它可以直接修改一个对象的属性。
 * https://www.cnblogs.com/myadmin/p/7634702.html
 * Spring源码分析-BeanWrapper
 * https://blog.csdn.net/shenchaohao12321/article/details/80326142
 * Spring容器技术内幕之BeanWrapper类介绍
 * https://www.cnblogs.com/xiao2/p/7711850.html
 * @Author
 * @Date
 * @Version 1.0
 */
public class App4Wrapper {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            wrapperTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void wrapperTest() {
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
}

