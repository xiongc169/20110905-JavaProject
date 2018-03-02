package org.practice.java8.para;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.practice.java8.para.para02Interface.GreetImpl;
import org.practice.java8.para.para02Interface.IGreet;
import org.practice.java8.para.para07Stream.Student;

/**
 * http://www.cnblogs.com/pkufork/p/java_8.html
 * 
 * @author Administrator
 *
 */
public class App {

	public static void main(String[] args) {

		// interfaceTest();
		streamTest();
	}

	public static void lambdaTest() {
		List<String> list = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
		list.forEach((item) -> {
			System.out.println(item);
		});
	}

	public static void interfaceTest() {
		IGreet greet = new GreetImpl();
		greet.defaultMethod();
		greet.myMethod();
		IGreet.staticMethod();
	}

	public static void streamTest() {
		List<Student> stuList = new ArrayList<Student>();

		Student stu = new Student("id1", "name1", "sex1", 1);
		Student stu2 = new Student("id2", "name1", "sex2", 2);
		Student stu3 = new Student("id3", "name1", "sex3", 3);
		Student stu4 = new Student("id4", "name1", "sex4", 4);
		stuList.add(stu);
		stuList.add(stu2);
		stuList.add(stu3);
		stuList.add(stu4);

		Predicate<Student> pred = item -> item.getAge() >= 3;
		stuList.forEach(item -> {
			if (pred.test(item)) {
				// System.out.println(item.getId());
			}
		});

		stuList.forEach(item -> System.out.println(item.getId()));
		stuList.stream().filter(pred).forEach(item -> System.out.println(item.getId()));
		stuList.parallelStream().forEach(item -> System.out.println(item.getId()));

		int sum = stuList.stream().mapToInt(item -> item.getAge()).sum();
		System.out.println(sum);

	}

	public static void array2Stream() {
		Student[] stuArrays = new Student[] { new Student("id1", "name1", "sex1", 1),
				new Student("id1", "name1", "sex1", 1), new Student("id1", "name1", "sex1", 1) };

		// 从数组创建流
		Stream stuStream1 = Stream.of(stuArrays);
		Stream stuStream2 = Arrays.stream(stuArrays);

	}

}
