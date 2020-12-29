package com.yoong.mybatis.api.source;

import com.yoong.mybatis.api.wong_user.dao.AccountMapper;
import com.yoong.mybatis.api.wong_user.domain.Account;
import com.yoong.mybatis.api.wong_user.domain.AccountExample;
import org.apache.ibatis.binding.MapperProxyFactory;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.io.ClassLoaderWrapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.parsing.XPathParser;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.xml.sax.EntityResolver;

import javax.xml.xpath.XPath;
import java.io.InputStream;
import java.util.List;

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
            reflect0202();
            //2.3、类型转换
            typeHandler0203();
            //2.4、日志模块
            log0204();
            //2.5、资源加载
            classLoader0205();
            //2.8、Binding模块
            binding0208();
            Chap03.ognl030202();
            Chap04.ognl040302();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void xpath0201() throws Exception {
        XPath xPath = null; //new XPathImpl(null, null);
        XPathParser xPathParser = new XPathParser("");
        EntityResolver entityResolver = new XMLMapperEntityResolver();
    }

    public static void reflect0202() throws Exception {
        //2.2.1、Reflector & ReflectorFactory
        Chap02.reflect020201();
        Chap02.typeParameterResolver020202();
        Chap02.objectFactory020203();
        Chap02.property020204();
        Chap02.metaClass020205();
        Chap02.objectWrapper020206();
        Chap02.metaObject020207();
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
        String resource = "mybatis-wong_user.xml";
        InputStream iStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(iStream);
        SqlSession session = factory.openSession();

        MapperProxyFactory mapperProxyFactory = new MapperProxyFactory(AccountMapper.class);
        AccountMapper accountMapper = (AccountMapper) mapperProxyFactory.newInstance(session);

        AccountExample example = new AccountExample();
        example.createCriteria().andAccountIdEqualTo("12345");
        List<Account> accountList = accountMapper.selectByExample(example);

        //Map<Method, MapperMethod> mapperMethodMap = mapperProxyFactory.getMethodCache();
        //MapperMethod mapperMethod = mapperMethodMap.get(1);
        //MapperProxy mapperProxy = new MapperProxy(session, AccountMapper.class, mapperMethodMap);
        //mapperProxy.invoke();

        System.out.println(accountList);
    }
}
