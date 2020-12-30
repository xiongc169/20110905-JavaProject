package com.yoong.mybatis.api.source;

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
            chap02();
            chap03();
            chap04();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void chap02() throws Exception {
        //2.1、解析器模块
        Chap02.xpath0201();
        //2.2、反射工具箱
        Chap02.reflect020201();
        Chap02.typeParameterResolver020202();
        Chap02.objectFactory020203();
        Chap02.property020204();
        Chap02.metaClass020205();
        Chap02.objectWrapper020206();
        Chap02.metaObject020207();
        //2.3、类型转换
        Chap02.typeHandler0203();
        //2.4、日志模块
        Chap02.log0204();
        //2.5、资源加载
        Chap02.classLoader0205();
        //2.8、Binding模块
        Chap02.binding0208();
    }

    public static void chap03() throws Exception {
        Chap03.mybatisInit0301();
        Chap03.sqlSource_sqlNode0302();
        Chap03.ognl030202();
        Chap03.resultSetHandler0303();
        Chap03.keyGenerator0304();
        Chap03.statementHandler0305();
        Chap03.executor0306();
        Chap03.sqlSession0307();
    }

    public static void chap04() throws Exception {
        Chap04.ognl040302();
    }
}
