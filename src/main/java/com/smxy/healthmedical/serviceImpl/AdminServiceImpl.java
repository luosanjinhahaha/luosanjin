package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.*;
import com.smxy.healthmedical.dao.AdminRoleMapper;
import com.smxy.healthmedical.dao.AdminUsersMapper;
import com.smxy.healthmedical.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoxin
 */
@Service
public class AdminServiceImpl implements AdminService {

	private final AdminUsersMapper adminUsersMapper;
	private final AdminRoleMapper adminRoleMapper;

	@Autowired
	public AdminServiceImpl(AdminUsersMapper adminUsersMapper,AdminRoleMapper adminRoleMapper) {
		this.adminUsersMapper = adminUsersMapper;
		this.adminRoleMapper = adminRoleMapper;
	}

	@Override
	public List<AdminUsers> getadmin() {
		return  adminUsersMapper.selectByExample(null);
	}
	@Override
	public void updatelimitadmin(AdminUsers adminUsers) {
		adminUsersMapper.updateByPrimaryKeySelective(adminUsers);
	}

	@Override
	public List<Role> verifyRole(Integer adminId) {
		return null;
	}

	@Override
	public List<Permission> verifyPermission(Integer adminId) {
	    List<Permission> permissions = new ArrayList<>();
        for (AdminUserRole adminUserRole : adminRoleMapper.getAdminUserRoleByAdminId(adminId)) {
            for (RolePermission rolePermission : adminUserRole.getRole().getRolePermissions()) {
				System.out.println("权限！！！！" + rolePermission.getPermission());
                permissions.add(rolePermission.getPermission());
            }
        }
		return permissions;
	}

	@Override
	public List<Role> getAdminRoleByAdminId(Integer adminId) {
			List<Role> roles = new ArrayList<>();
			for (AdminUserRole adminUserRole : adminRoleMapper.getAdminUserRoleByAdminId(adminId)) {
				roles.add(adminUserRole.getRole());
			}
		return roles;
	}

}
