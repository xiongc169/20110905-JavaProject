package com.yoong.mybatis.accidence.yunyi.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.yoong.mybatis.accidence.yunyi.domain.Noticelogs;
import com.yoong.mybatis.accidence.yunyi.domain.NoticelogsExample;
import com.yoong.mybatis.accidence.yunyi.domain.NoticelogsWithBLOBs;

public interface NoticelogsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NoticeLogs
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    int countByExample(NoticelogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NoticeLogs
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    int deleteByExample(NoticelogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NoticeLogs
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NoticeLogs
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    int insert(NoticelogsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NoticeLogs
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    int insertSelective(NoticelogsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NoticeLogs
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    List<NoticelogsWithBLOBs> selectByExampleWithBLOBs(NoticelogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NoticeLogs
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    List<Noticelogs> selectByExample(NoticelogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NoticeLogs
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    NoticelogsWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NoticeLogs
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    int updateByExampleSelective(@Param("record") NoticelogsWithBLOBs record, @Param("example") NoticelogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NoticeLogs
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") NoticelogsWithBLOBs record, @Param("example") NoticelogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NoticeLogs
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    int updateByExample(@Param("record") Noticelogs record, @Param("example") NoticelogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NoticeLogs
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    int updateByPrimaryKeySelective(NoticelogsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NoticeLogs
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(NoticelogsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NoticeLogs
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    int updateByPrimaryKey(Noticelogs record);
}