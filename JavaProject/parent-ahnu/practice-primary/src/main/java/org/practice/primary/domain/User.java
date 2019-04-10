package org.practice.primary.domain;

import lombok.Data;

/**
 * 序列化
 *
 * @author Administrator
 */
@Data
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

//	public String toString() {
//		System.out.println("This is User.toString() Method");
//		return "my iid:" + iid + ", my userNo:" + userNo;
//	}

    public void sayHello(int age, String name) {
        System.out.println("This is User.sayHello() Method: age is " + age + "; name is " + name);
    }

}
