package org.practice.primary.book01.chap06;

/**
 * @Desc MyInterface
 * @Author
 * @Date
 * @Version 1.0
 */
public interface MyInterface {

    /**
     * 接口中不能包含实例域、静态方法(若有则必须实现)，但却可以包含常量。
     * 接口中的方法自动设置为public，接口中的域自动设置为public static final。
     */
    public static final Integer interfaceId = 10;
    //public Integer uuid;
    //protected String interfaceName = "name";
    //private String interfaceDesc = "desc";

    //接口中不能有方法的实现
    //String getName() {
    //    return "name";
    //}

    //接口中不能有静态方法(若有则必须实现)
    static String getName() {
        return "";
    }

    //所有方法自动属于public
    public String getDesc();
}
