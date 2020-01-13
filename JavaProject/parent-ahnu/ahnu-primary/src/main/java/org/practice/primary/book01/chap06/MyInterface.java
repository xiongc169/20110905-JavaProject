package org.practice.primary.book01.chap06;

public interface MyInterface {

    public Integer interfaceId = 10;
    //protected String interfaceName = "name";
    //private String interfaceDesc = "desc";

    //接口中不能有方法的实现
    //String getName() {
    //    return "name";
    //}

    //所有方法自动属于public
    public String getDesc();
}
