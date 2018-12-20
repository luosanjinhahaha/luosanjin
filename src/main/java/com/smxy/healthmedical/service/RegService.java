package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.User;

public interface RegService {
	public void reg(User user);
	public User queryuser(User user);
	public User queryuserbyid(String username);
}
