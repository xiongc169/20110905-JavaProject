package org.practice.primary.domain;

import java.util.HashSet;
import java.util.Set;

public class App {

	public static void main(String[] args) {

		// BaseClass baseClass = new BaseClass();
		// DeriveClass derive = new DeriveClass();

		setTest();
	}

	/**
	 * http://blog.csdn.net/miqi770/article/details/8998517
	 */
	public static void setTest() {
		Set<Student> stuSet = new HashSet<Student>();
		Student stu = new Student("id1", "name1", "sex1", 1);
		Student stu2 = new Student("id2", "name1", "sex2", 2);
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

}
