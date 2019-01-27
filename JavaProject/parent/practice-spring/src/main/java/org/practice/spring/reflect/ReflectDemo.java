package org.practice.spring.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.practice.spring.domain.User;

/**
 * @author yoong
 *
 * @version 1.0
 *
 * @desc Java反射机制详解 <br>
 *      http://www.cnblogs.com/lzq198754/p/5780331.html
 *
 * @date 2014年4月2日
 */
public class ReflectDemo {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            reflectDemo();
            annotationTest();

            Object demo = Class.forName(ReflectDemo.class.getName()).newInstance();
            Method sayHello = demo.getClass().getMethod("sayHello", String.class);
            sayHello.invoke(demo,"2019年1月27日15:28:38");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 反射
     */
    public static void reflectDemo() {
        try {
            // 1、获取Class实例
            Class<?> usrClass = User.class;
            Class<?> usrClass2 = new User().getClass();
            Class<?> usrClass3 = Class.forName("org.practice.primary.domain.User");
            String className = usrClass.getName();
            System.out.println(className);

            // 2、获取类的父类、接口
            Class<?> superClass = usrClass.getSuperclass();
            Class<?>[] interfaces = usrClass.getInterfaces();

            // 3、获取本类的全部属性、构造函数、方法
            Field[] fields = usrClass.getDeclaredFields();
            Constructor[] cons = usrClass.getConstructors();
            Method[] methods = usrClass.getMethods();

            // 4、获取父类、接口的全部属性
            Field[] superFields = usrClass.getFields();

            // 5、创建类实例（setter方法赋值、构造函数赋值）
            User user = (User) usrClass.newInstance();
            user.setIid("myIId");
            user.setUserNo("myUserNo");
            String str = user.toString();
            System.out.println(str);
            // User user2 = (User) cons[0].newInstance("iid", "userNo");

            // 6、调用类的方法
            Method method = usrClass.getMethod("toString");
            method.invoke(user);
            Method method2 = usrClass.getMethod("sayHello", int.class, String.class);
            method2.invoke(user, 123, "Dog");

            // 7、操作类的属性
            Field field = usrClass.getDeclaredField("iid");
            field.setAccessible(true);
            field.set(user, "newIId");
        } catch (Exception ex) {
            String msg = ex.getMessage();
        }
    }

    /**
     * 反射获取注解信息
     */
    public static void annotationTest() {
        Class utilClz = User.class;
        ClassLoader loader = utilClz.getClassLoader();
        Method[] methods = utilClz.getMethods();
        for (Method m : methods) {
            // 判断方法是否包含MethodInfo注解
            if (m.isAnnotationPresent(MethodInfo.class)) {
                MethodInfo method2 = m.getAnnotation(MethodInfo.class);
                if (method2 != null) {
                    System.out.println(method2.author());
                }
            }
            Annotation[] annations = m.getAnnotations();
            for (Annotation ann : annations) {
                if (ann.annotationType().isInstance(MethodInfo.class)) {
                    MethodInfo method = (MethodInfo) ann;
                    System.out.println(method.comments());
                }
            }
        }
    }

    /**
     * 反射调用的方法
     * PS：《深入浅出Mybatis技术原理与实战》第六章 (P130)
     * @param msg
     */
    public void sayHello(String msg) {
        System.out.println("ReflectDemo.sayHello: " + msg);
    }
}
