package com.yoong.junior.community.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Desc User
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015/5/25 16:49
 * <p>
 * @Version 1.0
 */
@Data
public class User implements Serializable {
    //static属性，JSON序列化时不会序列化
    protected static String className = "User";
    //transient属性，JSON序列化时不会序列化
    protected transient String iid;
    protected String userNo;
    protected String name;
    protected String orgNo;
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
