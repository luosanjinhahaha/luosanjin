package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.AdminUsers;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
	public AdminUsers getAdmin(AdminUsers adminUsers, HttpServletRequest request);
	public AdminUsers getAdminByName(String adminName);
}
