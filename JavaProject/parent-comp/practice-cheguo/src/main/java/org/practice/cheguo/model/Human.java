package org.practice.cheguo.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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
public class Human implements Serializable {

	private static final long serialVersionUID = 1L;

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

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj instanceof Human) {
			Human stu = (Human) obj;
			if (stu.getName() == this.name && stu.getAge() == this.age) {
				return true;
			}
		}
		return false;

		// return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return this.getName().hashCode() + this.getAge();
		// return HashCodeBuilder.reflectionHashCode(this);
	}
}
