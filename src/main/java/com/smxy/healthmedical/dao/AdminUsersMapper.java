package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.AdminUsers;
import com.smxy.healthmedical.bean.AdminUsersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface AdminUsersMapper {
    long countByExample(AdminUsersExample example);

    int deleteByExample(AdminUsersExample example);

    int deleteByPrimaryKey(Integer adminId);

    int insert(AdminUsers record);

    int insertSelective(AdminUsers record);

    List<AdminUsers> selectByExample(AdminUsersExample example);

    AdminUsers selectByPrimaryKey(Integer adminId);

    int updateByExampleSelective(@Param("record") AdminUsers record, @Param("example") AdminUsersExample example);

    int updateByExample(@Param("record") AdminUsers record, @Param("example") AdminUsersExample example);

    int updateByPrimaryKeySelective(AdminUsers record);

    int updateByPrimaryKey(AdminUsers record);
    
    AdminUsers query(AdminUsers adminUsers);

    AdminUsers queryByName(String adminName);
}