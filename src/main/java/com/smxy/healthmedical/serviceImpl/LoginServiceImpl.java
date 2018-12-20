package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.AdminUsers;
import com.smxy.healthmedical.dao.AdminUsersMapper;
import com.smxy.healthmedical.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	AdminUsersMapper adminUsersMapper;
	@Override
	public AdminUsers getAdmin(AdminUsers adminUsers, HttpServletRequest request) {
		if(adminUsersMapper.query(adminUsers) == null){
			return null;
		}else{
			return adminUsers;
		}
	}

	@Override
	public AdminUsers getAdminByName(String name) {
		return adminUsersMapper.queryByName(name);
	}

}
