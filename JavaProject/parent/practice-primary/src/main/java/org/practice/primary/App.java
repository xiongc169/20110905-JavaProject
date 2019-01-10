package org.practice.primary;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.practice.primary.init_order.DeriveClass;
import org.practice.primary.domain.Dictionary;
import org.practice.primary.domain.Student;
import org.practice.primary.utility.CollectionUtility;

/**
 * @author yoong
 *
 * @description App.java
 *
 * @date 2012年4月2日
 *
 * @version 1.0
 *
 */
public class App {

	/**
	 * 入口函数
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			initOrderTest();
			hashCodeTest();
			setDistinctTest();
			getTimestamp();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 静态变量、静态代码块、变量、代码块、构造函数的执行顺序
	 */
	private static void initOrderTest() {
		DeriveClass deriveClass = new DeriveClass();
		DeriveClass.staticSay();
		deriveClass.say();
	}

	/**
	 * hashCode测试
	 * java对象克隆以及深拷贝和浅拷贝
	 * http://www.cnblogs.com/xuanxufeng/p/6558330.html
	 */
	public static void hashCodeTest() {
		Dictionary dict = new Dictionary();
		int hashCode = dict.hashCode();
		System.out.println("hashCode " + hashCode);

		Dictionary dict2 = new Dictionary("12", "12");
		int hashCode2 = dict2.hashCode();
		System.out.println("hashCode2 " + hashCode2);

		Dictionary dict3 = new Dictionary("12", "12");
		int hashCode3 = dict3.hashCode();
		System.out.println("hashCode3 " + hashCode3);

		//Dictionary dict4 = dict3;
		Dictionary dict4 = (Dictionary) dict3.clone();
		int hashCode4 = dict4.hashCode();
		System.out.println("hashCode4 " + hashCode4);
	}

	/**
	 * @desc https://blog.csdn.net/miqi770/article/details/8998517 <br>
	 * 		 利用Java Set 去除重复object，重写equals\hashcode方法
	 * @date 2014年4月2日
	 * @version 1.0
	 */
	public static void setDistinctTest() {
		Set<Student> stuSet = new HashSet<Student>();
		Student stu = new Student("id1", "name1", "sex1", 1);
		Student stu2 = new Student("id1", "name1", "sex2", 2);
		Student stu3 = new Student("id3", "name1", "sex3", 3);
		Student stu4 = new Student("id4", "name1", "sex4", 4);

		System.out.printf("%d ; %d ; %d ; %d \n", stu.hashCode(), stu2.hashCode(), stu3.hashCode(), stu4.hashCode());

		stuSet.add(stu);
		stuSet.add(stu2);
		stuSet.add(stu3);
		stuSet.add(stu4);

		for (Student item : stuSet) {
			System.out.printf("%s - %s - %s - %d\n", item.getId(), item.getName(), item.getSex(), item.getAge());
		}
	}

	/**
	 * Java获取时间戳：http://tangmingjie2009.iteye.com/blog/1543166 <br>
	 * Java时间戳、时间转换：http://www.cnblogs.com/mstk/p/5511057.html <br>
	 * java生成时间戳，13位<br>
	 * .net生成时间戳，10位
	 */
	public static void getTimestamp() {

		// 获取时间戳
		long timestamp = System.currentTimeMillis();
		long timestamp2 = Calendar.getInstance().getTimeInMillis();
		long timestamp3 = new Date().getTime();
		System.out.println(timestamp);
		System.out.println(timestamp2);
		System.out.println(timestamp3);

		// 时间戳转换为时间
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long timestamp4 = 1509004771699L;
		Date date = new Date(timestamp4);
		String dateStr = simpleDateFormat.format(date);
		System.out.println(dateStr);

		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		String dateStr2 = format.format(new Date());
		System.out.println(dateStr2);
	}

}
