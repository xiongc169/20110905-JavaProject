package org.practice.springfx.community01.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.practice.springfx.domain.Car;
import org.practice.springfx.domain.User;

/**
 * @Desc Java反射机制详解
 * http://www.cnblogs.com/lzq198754/p/5780331.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2014年3月30日
 * <p>
 * @Version 1.0
 */
public class ReflectDemo {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            reflectDemo();
            annotationTest();

            genCar();
            reflectDemo2();
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
            Class<?> usrClass3 = Class.forName("org.practice.springfx.domain.User");
            String className = usrClass.getName();
            System.out.println(className);

            // 2、获取类的父类、接口
            Class<?> superClass = usrClass.getSuperclass();
            Class<?>[] interfaces = usrClass.getInterfaces();
            System.out.println(superClass.getName());
            System.out.println(interfaces.length);

            // 3、获取本类的全部属性、构造函数、方法
            Field[] fields = usrClass.getDeclaredFields();
            Constructor[] cons = usrClass.getConstructors();
            Method[] methods = usrClass.getMethods();
            System.out.println(fields.length);
            System.out.println(cons.length);
            System.out.println(methods.length);

            // 4、获取父类、接口的全部属性
            Field[] superFields = usrClass.getFields();
            System.out.println(superFields.length);

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
            System.out.println(user.getIid());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 反射获取注解信息
     */
    public static void annotationTest() {
        Class usrClz = User.class;
        ClassLoader loader = usrClz.getClassLoader();
        Method[] methods = usrClz.getMethods();
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
     */
    public static void genCar() {
        try {
            Class carClz = Car.class;
            Car car = (Car) carClz.newInstance();
            Method setCarId = carClz.getMethod("setCarId", String.class);
            Method setCarBrandName = carClz.getMethod("setCarBrandName", String.class);
            Method setCarModelName = carClz.getMethod("setCarModelName", String.class);
            Method output = carClz.getMethod("output", null);

            setCarId.invoke(car, "carId");
            setCarBrandName.invoke(car, "carBrandName");
            setCarModelName.invoke(car, "carModelName");

            Object outputResult = output.invoke(car, null);
            System.out.println(outputResult);

            ClassLoader clzLoader = carClz.getClassLoader();
            System.out.println("ClzLoader: " + clzLoader);
            ClassLoader pClzLoader = clzLoader.getParent();
            System.out.println("pClzLoader: " + pClzLoader);
            ClassLoader ppClzLoader = pClzLoader.getParent();
            System.out.println("ppClzLoader: " + ppClzLoader);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 《Spring 3.x企业应用开发实战》-chap04
     */
    public static void reflectDemo2() {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            Class clz = loader.loadClass("org.practice.springfx.domain.Car");
            if (clz == Car.class) {
                Car car = (Car) clz.newInstance();
                Method setCarId = clz.getMethod("setCarId", String.class);
                setCarId.invoke(car, "reflect_car_id");
                System.out.println(car.getCarId());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
