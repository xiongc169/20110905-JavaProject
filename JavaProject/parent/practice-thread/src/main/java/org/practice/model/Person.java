package org.practice.model;

public class Person {

	private String name;

	private int age;

	private int salary;

	static {
		System.out.println("");
	}

	/**
	 * 无参构造函数
	 */
	public Person() {
	}

	/**
	 * 构造函数
	 * 
	 * @param name
	 * @param age
	 * @param salary
	 */
	public Person(String name, int age, int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

}
