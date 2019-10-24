package com.yoong.practice.mybatis.accidence.northwind;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.yoong.practice.mybatis.accidence.northwind.domain.Categories;

/**
 * @author Administrator
 * <br>
 * @version 2016-6-1 09:55:00
 * <br>
 * @Desc
 */
public class NorthWindManager {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            northWindTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void northWindTest() {
        try {
            String resource = "mybatis-northwind.xml";
            InputStream iStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(iStream);
            SqlSession session = factory.openSession();
            Categories result = session.selectOne("com.yoong.practice.mybatis.accidence.northwind.dao.CategoriesMapper.selectByPrimaryKey", 28);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
