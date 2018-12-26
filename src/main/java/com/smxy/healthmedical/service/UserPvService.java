package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.UserPv;

import java.util.List;

public interface UserPvService {

    /*添加用户pv操作记录*/
    void addUserPv(UserPv userPv);

    /*查出所有记录*/
    List<UserPv> findUserPvAll();

    /*通过用户名和模块名查出数据*/
    UserPv findUserPvByExample(UserPv userPv);

    /*通过name值更新userPv的记录数*/
    void updatePvUserInfo(UserPv userPv);
}
