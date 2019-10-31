package org.practice.primary.book02.chap02;

import java.io.*;
import java.util.Properties;

/**
 * @Desc 《Java核心技术·卷2·高级特性·第9版》
 * 第二章、XML
 * @Author
 * @Date
 * @Version 1.0
 */
public class XmlUtils {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            String propertyPath = "D:\\home\\upload\\datasource.properties";
            propertyTest(propertyPath);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //2.1、XML概述
    public static Properties propertyTest(String propertyPath) throws Exception {
        FileInputStream fileInStream = new FileInputStream(propertyPath);
        Properties properties = new Properties();
        properties.load(fileInStream);
        System.out.println(properties.entrySet().size());
        return properties;
    }

}