package org.practice.mybatis.northwind.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.practice.mybatis.northwind.domain.Orders;
import org.practice.mybatis.northwind.domain.OrdersExample;

public interface OrdersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Orders
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int countByExample(OrdersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Orders
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int deleteByExample(OrdersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Orders
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int deleteByPrimaryKey(Integer orderid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Orders
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int insert(Orders record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Orders
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int insertSelective(Orders record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Orders
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    List<Orders> selectByExample(OrdersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Orders
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    Orders selectByPrimaryKey(Integer orderid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Orders
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Orders
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Orders
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int updateByPrimaryKeySelective(Orders record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Orders
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int updateByPrimaryKey(Orders record);
}