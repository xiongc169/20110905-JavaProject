package org.practice.cheguo.model;

import java.util.Date;

/**
 * @author yoong
 *
 * @description Human
 *
 * @date 2018年4月27日
 *
 * @version 1.0
 *
 */
public class Human {

	private String name;

	private int age;
	
	private Date createDate;

	public Human() {
		super();
	}

	public Human(final String name, final int age) {
		super();

		this.name = name;
		this.age = age;
	}
	

	public Human(final String name, final int age, final Date createDate) {
		super();

		this.name = name;
		this.age = age;
		this.createDate = createDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	

}
