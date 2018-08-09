package org.practice.spring.domain;

import org.practice.spring.reflect.MethodInfo;

/**
 * 序列化
 * 
 * @author yoong
 *
 */
public class User {

	/**
	 * Id，非空，长度应为36
	 */
	protected String iid;

	/**
	 * 编号，非空，最大长度为36
	 */
	protected String userNo;

	/**
	 * 姓名，非空，最大长度为30
	 */
	protected String name;

	/**
	 * 所属单位编号，非空，最大长度为36
	 */
	protected String orgNo;

	/**
	 * 所属单位名称，非空，最大长度为80
	 */
	protected String orgName;

	public User() {
	}

	public User(String iid) {
		this.iid = iid;
	}

	public User(String iid, String userNo) {
		this.iid = iid;
		this.userNo = userNo;
	}

	/**
	 * @return the iid
	 */
	public String getIid() {
		return iid;
	}

	/**
	 * @param iid the iid to set
	 */
	public void setIid(String iid) {
		this.iid = iid;
	}

	/**
	 * @return the userNo
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * @param userNo the userNo to set
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
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
	 * @return the orgNo
	 */
	public String getOrgNo() {
		return orgNo;
	}

	/**
	 * @param orgNo the orgNo to set
	 */
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	// public String toString() {
	// System.out.println("This is User.toString() Method");
	// return "my iid:" + iid + ", my userNo:" + userNo;
	// }

	@MethodInfo(comments = "sayHello Method", date = "2018年8月9日10:56:05", version = "V 1.0")
	public void sayHello(int age, String name) {
		System.out.println("This is User.sayHello() Method: age is " + age + "; name is " + name);
	}

}
