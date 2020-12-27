package com.yoong.mybatis.api;

import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.parsing.XPathParser;
import org.apache.ibatis.reflection.*;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.property.PropertyCopier;
import org.apache.ibatis.reflection.property.PropertyNamer;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.xml.sax.EntityResolver;

import java.lang.reflect.*;

/**
 * @Desc 《MyBatis技术内幕》
 * <p>
 * @Author Administrator
 * <p>
 * @Date 2018/1/16 16:41
 * <p>
 * @Version 1.0
 */
public class AppMybatisSource {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //2.1、解析器模块
            xpath0201();
            //2.2、反射工具箱
            //2.2.1、Reflector & ReflectorFactory
            reflect020201();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void xpath0201() throws Exception {
        //XPath xPath = new XPathImpl(null, null);
        XPathParser xPathParser = new XPathParser("");
        EntityResolver entityResolver = new XMLMapperEntityResolver();
    }

    private static void reflect020201() throws Exception {
        //Class driverClazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Class accountClazz = Class.forName("com.yoong.mybatis.api.wong_user.domain.Account");
        Reflector reflector = new Reflector(accountClazz);
        System.out.println(reflector);
        ReflectorFactory reflectorFactory = new DefaultReflectorFactory();

        //OgnlUtils.
        String mysql = new SQL() {
            {
                SELECT("*");
                FROM("a");
                INNER_JOIN("b on a.id=b.id");
                WHERE("a.age>10");
            }
        }.toString();
    }

    private static void typeParameterResolver020202() throws Exception {
        Type type = null;
        Class clazz = null;
        ParameterizedType parameterizedType = null;
        GenericArrayType genericArrayType = null;
        TypeVariable typeVariable = null;
        WildcardType wildcardType = null;
        TypeParameterResolver typeParameterResolver = null;
    }

    private static void objectFactory020203() throws Exception {
        DefaultObjectFactory defaultObjectFactory = null;
    }

    private static void property020204() throws Exception {
        PropertyTokenizer propertyTokenizer = null;
        PropertyNamer propertyNamer = null;
        PropertyCopier propertyCopier = null;
    }

    private static void metaClass020205() throws Exception {
        MetaClass metaClass = null;
    }

    private static void objectWrapper20206() throws Exception {
        ObjectWrapper objectWrapper = null;
        ObjectWrapperFactory objectWrapperFactory = null;
    }

    private static void metaObject020207() throws Exception {
        MetaObject metaObject = null;
    }
}
