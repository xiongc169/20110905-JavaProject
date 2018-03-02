package org.practice.primary.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.practice.primary.domain.User;


/**
 * 
 * @author Administrator <br/>
 *         http://www.cnblogs.com/lzq198754/p/5780331.html
 *
 */
public class ReflectDemo {

	public static void main(String[] args) {

		// try {
		// Class usrClass = User.class;
		// Class usrClass2 = Class.forName("com.yoong.domain.User");
		// Class usrClass3 = new User().getClass();
		//
		// String className = usrClass.getName();
		// System.out.println(className);
		//
		// Constructor[] cons = usrClass.getConstructors();
		// Field[] fields = usrClass.getDeclaredFields();
		// Method[] methods = usrClass.getMethods();
		//
		// User user = (User) usrClass.newInstance();
		// Method sayHello = usrClass.getMethod("sayHello", int.class,
		// String.class);
		// sayHello.invoke(user, 100, "Yoong");
		//
		// } catch (Exception ex) {
		// String msg = ex.getMessage();
		// System.out.println(msg);
		// }

		reflectDemo();
	}

	public static void reflectDemo() {
		try {
			// 1、获取Class实例
			Class<?> usrClass = User.class;
			Class<?> usrClass2 = new User().getClass();
			Class<?> usrClass3 = Class.forName("com.yoong.domain.User");
			// 2、获取类的父类、接口
			Class<?> superClass = usrClass.getSuperclass();
			Class<?>[] interfaces = usrClass.getInterfaces();

			String className = usrClass.getName();
			System.out.println(className);
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

}
