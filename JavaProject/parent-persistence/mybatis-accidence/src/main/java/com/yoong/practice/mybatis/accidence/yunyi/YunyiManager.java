package com.yoong.practice.mybatis.accidence.yunyi;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.yoong.practice.mybatis.accidence.yunyi.dao.NoticeMapper;
import com.yoong.practice.mybatis.accidence.yunyi.domain.Accounts;
import com.yoong.practice.mybatis.accidence.yunyi.domain.Notice;
import com.yoong.practice.mybatis.accidence.yunyi.domain.NoticeExample;

/**
 * @author Administrator
 * <br>
 * @desc desc
 * <br>
 * @date 2016/5/1 16:00:00
 */
public class YunyiManager {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            yunyiTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void yunyiTest() {
        SqlSession session = null;
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-yunyi.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(reader);
            session = factory.openSession();
            // 1、iBatis用法：命名空间+SQL Id
            Accounts accounts = session.selectOne("com.yoong.practice.mybatis.accidence.yunyi.dao.AccountsMapper.selectByPrimaryKey", "201609191454299903499203");
            System.out.println(accounts.getAccountid());
            //session.commit();

            // 2、MyBatis用法：获取映射器
            NoticeExample noticeExample = new NoticeExample();
            NoticeMapper noticeDao = session.getMapper(NoticeMapper.class);
            List<Notice> noticeList = noticeDao.selectByExample(noticeExample);
            int count = noticeList.size();
            System.out.println("Notice Length:" + count);

            Notice notice = noticeDao.selectByPrimaryKey("DC198D89-4A54-423C-8B05-00029D493D61");
            System.out.println(notice.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
