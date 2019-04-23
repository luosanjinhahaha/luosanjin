package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.User;
import com.smxy.healthmedical.bean.UserPreference;
import com.smxy.healthmedical.bean.UserPv;
import org.apache.ibatis.annotations.Mapper;
/**
 * 功能描述:
 * @param:
 * @return:
 * @auther: luoxin
 * @date: 2018/10/21 15:58
 */

public interface RegMapper {

	void reg(User user);

	User queryuser(User user);

	User queryByUserName(String username);

	UserPv queryPreference(String realname);
}
