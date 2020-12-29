package com.yoong.mybatis.api.source;

import org.apache.ibatis.reflection.*;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.property.PropertyCopier;
import org.apache.ibatis.reflection.property.PropertyNamer;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

import java.lang.reflect.*;

public class Chap02 {

    public static void reflect020201() throws Exception {
        //Class driverClazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Class accountClazz = Class.forName("com.yoong.mybatis.api.wong_user.domain.Account");
        Reflector reflector = new Reflector(accountClazz);
        System.out.println(reflector);
        ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
    }

    public static void typeParameterResolver020202() throws Exception {
        Type type = null;
        Class clazz = null;
        ParameterizedType parameterizedType = null;
        GenericArrayType genericArrayType = null;
        TypeVariable typeVariable = null;
        WildcardType wildcardType = null;
        TypeParameterResolver typeParameterResolver = null;
    }

    public static void objectFactory020203() throws Exception {
        DefaultObjectFactory defaultObjectFactory = null;
    }

    public static void property020204() throws Exception {
        PropertyTokenizer propertyTokenizer = null;
        PropertyNamer propertyNamer = null;
        PropertyCopier propertyCopier = null;
    }

    public static void metaClass020205() throws Exception {
        MetaClass metaClass = null;
    }

    public static void objectWrapper020206() throws Exception {
        ObjectWrapper objectWrapper = null;
        ObjectWrapperFactory objectWrapperFactory = null;
    }

    public static void metaObject020207() throws Exception {
        MetaObject metaObject = null;
    }
}
