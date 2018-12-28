package org.practice.spring.domain;

import org.practice.spring.reflect.MethodInfo;
import org.springframework.stereotype.Component;

/**
 * User
 *
 * @author yoong
 */
@Component
public class User {

    private String iid;

    private String userNo;

    private String name;

    private String orgNo;

    private String orgName;

    /**
     * BeanFactory\ApplicationContext容器中，执行顺序：静态代码块->构造函数->init方法
     */
    static {
        System.out.println("User.static()");
    }

    static void staticMethod() {
        System.out.println("User.staticMethod()");
    }

    public User() {
        System.out.println("User.User()");
    }

    public User(String iid) {
        this.iid = iid;
    }

    public User(String iid, String userNo) {
        this.iid = iid;
        this.userNo = userNo;
    }

    public void init() {
        System.out.println("User.init()");
    }

    public void destroy() {
        System.out.println("User.destroy()");
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getOrgName() {
        return orgName;
    }

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
