package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.User;
import com.smxy.healthmedical.bean.UserPreference;
import com.smxy.healthmedical.bean.UserPv;
import com.smxy.healthmedical.dao.RegMapper;
import com.smxy.healthmedical.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegServiceImpl implements RegService {
	@Autowired
	RegMapper regMapper;
	@Override
	public void reg(User user) {
		regMapper.reg(user);
		// TODO 自动生成的方法存根
	}
	@Override
	public User queryuser(User user) {
		return regMapper.queryuser(user);
	}

	@Override
	public User queryuserbyid(String username) {
		return regMapper.queryByUserName(username);
	}

	@Override
	public UserPv queryPreference(String realname) {
		UserPv preference = regMapper.queryPreference(realname);
		System.out.println("preference:" + preference);
		return preference;
	}
}
