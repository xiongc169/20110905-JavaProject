package org.dubbo.provider.starter.core.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.dubbo.provider.starter.core.model.RoleResource;
import org.dubbo.provider.starter.core.model.RoleResourceExample;

public interface RoleResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    long countByExample(RoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    int deleteByExample(RoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    int insert(RoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    int insertSelective(RoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    List<RoleResource> selectByExample(RoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    RoleResource selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    int updateByExampleSelective(@Param("record") RoleResource record, @Param("example") RoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    int updateByExample(@Param("record") RoleResource record, @Param("example") RoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    int updateByPrimaryKeySelective(RoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    int updateByPrimaryKey(RoleResource record);
}