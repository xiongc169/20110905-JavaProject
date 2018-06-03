package org.practice.mybatis.northwind.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.practice.mybatis.northwind.domain.Employees;
import org.practice.mybatis.northwind.domain.EmployeesExample;

public interface EmployeesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Employees
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int countByExample(EmployeesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Employees
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int deleteByExample(EmployeesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Employees
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int deleteByPrimaryKey(Integer employeeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Employees
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int insert(Employees record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Employees
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int insertSelective(Employees record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Employees
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    List<Employees> selectByExampleWithBLOBs(EmployeesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Employees
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    List<Employees> selectByExample(EmployeesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Employees
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    Employees selectByPrimaryKey(Integer employeeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Employees
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int updateByExampleSelective(@Param("record") Employees record, @Param("example") EmployeesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Employees
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") Employees record, @Param("example") EmployeesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Employees
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int updateByExample(@Param("record") Employees record, @Param("example") EmployeesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Employees
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int updateByPrimaryKeySelective(Employees record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Employees
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Employees record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Employees
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    int updateByPrimaryKey(Employees record);
}