package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.UserPv;

import java.util.List;

public interface UserPvMapper {

    /*添加用户pv操作记录*/
    void insertUserPvByPvName(UserPv userPv);

    /*查出所有记录*/
    List<UserPv> getUserPvAll();

    /*通过用户名和模块名查出数据*/
    UserPv getUserPvByNameAndModule(UserPv userPv);

    /*通过name值更新userPv的记录数*/
    void updateUserPv(UserPv userPv);
}
