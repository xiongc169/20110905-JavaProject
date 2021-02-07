package com.yoong.springfx.domain;

import com.yoong.springfx.community01.reflect.MethodInfo;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Desc User
 * <p>
 * @Author yoong
 * <p>
 * @Date 2014年3月30日
 * <p>
 * @Version 1.0
 */
@Data
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

    // public String toString() {
    // System.out.println("This is User.toString() Method");
    // return "my iid:" + iid + ", my userNo:" + userNo;
    // }

    @MethodInfo(comments = "sayHello Method", date = "2018年8月9日10:56:05", version = "V 1.0")
    public void sayHello(int age, String name) {
        System.out.println("This is User.sayHello() Method: age is " + age + "; name is " + name);
    }

}
