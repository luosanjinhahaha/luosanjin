package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.AdminUsers;
import com.smxy.healthmedical.bean.Permission;
import com.smxy.healthmedical.bean.Role;

import java.util.List;

public interface AdminService {
	List<AdminUsers> getadmin();
	void updatelimitadmin(AdminUsers adminUsers);

	/*通过管理员id查找管理员role*/
	List<Role> verifyRole(Integer adminId);

	/*通过管理员id查找管理员Permission*/
	List<Permission> verifyPermission(Integer adminId);

	/*通过管理员id获取管理员角色*/
	List<Role> getAdminRoleByAdminId(Integer adminId);
}
