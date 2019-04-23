package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.User;
import com.smxy.healthmedical.bean.UserPv;

public interface RegService {
	void reg(User user);

	User queryuser(User user);

	User queryuserbyid(String username);

	UserPv queryPreference(String realname);
}
