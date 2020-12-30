package com.yoong.mybatis.api.source;

import com.yoong.mybatis.api.wong_user.dao.AccountMapper;
import com.yoong.mybatis.api.wong_user.domain.Account;
import com.yoong.mybatis.api.wong_user.domain.AccountExample;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.binding.MapperProxy;
import org.apache.ibatis.binding.MapperProxyFactory;
import org.apache.ibatis.binding.MapperRegistry;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.io.ClassLoaderWrapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.parsing.XPathParser;
import org.apache.ibatis.reflection.*;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.property.PropertyCopier;
import org.apache.ibatis.reflection.property.PropertyNamer;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.xml.sax.EntityResolver;

import javax.xml.xpath.XPath;
import java.io.InputStream;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Chap02 {

    public static void xpath0201() throws Exception {
        XPath xPath = null; //new XPathImpl(null, null);
        XPathParser xPathParser = new XPathParser("");
        EntityResolver entityResolver = new XMLMapperEntityResolver();
    }

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


    public static void typeHandler0203() throws Exception {
        TypeHandler typeHandler = null;
        TypeHandlerRegistry typeHandlerRegistry = null;
        TypeAliasRegistry typeAliasRegistry = null;
    }

    public static void log0204() throws Exception {
    }

    public static void classLoader0205() throws Exception {
        ClassLoaderWrapper classLoaderWrapper = null;
    }

    public static void binding0208() throws Exception {
        //MapperRegistry、Mapper、MapperProxyFactory
        //MapperProxyFactory、MapperProxy、Method、MapperMethod
        String resource = "mybatis-wong_user.xml";
        InputStream iStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(iStream);
        SqlSession session = factory.openSession();
        MapperRegistry mapperRegistry = session.getConfiguration().getMapperRegistry();
        System.out.println(mapperRegistry.getMappers());

        //必须在基础配置文件中 先配置好mapper，否则执行查询操作会报错：org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): com.yoong.mybatis.api.wong_user.dao.AccountMapper.selectByExample
        MapperProxyFactory mapperProxyFactory = new MapperProxyFactory(AccountMapper.class);
        AccountMapper accountMapper = (AccountMapper) mapperProxyFactory.newInstance(session);
        MapperRegistry mapperRegistry02 = session.getConfiguration().getMapperRegistry();
        System.out.println(mapperRegistry02.getMappers());

        AccountExample example = new AccountExample();
        example.createCriteria().andAccountIdEqualTo("12345");
        List<Account> accountList = accountMapper.selectByExample(example);

        Map<Method, MapperMethod> mapperMethodMap = mapperProxyFactory.getMethodCache();
        List<MapperMethod> mapperMethodList = new ArrayList<>();
        for (Map.Entry<Method, MapperMethod> item : mapperMethodMap.entrySet()) {
            mapperMethodList.add(item.getValue());
        }
        Integer index = 0;
        MapperProxy mapperProxy = new MapperProxy(session, AccountMapper.class, mapperMethodMap);
        //Object result = mapperProxy.invoke(accountMapper, mapperMethodList.get(index), new Object[]{"12345"});
        //mapperProxy.execute();

        Object result02 = mapperMethodList.get(index).execute(session, new Object[]{"12345"});
        System.out.println(accountList);
    }
}
