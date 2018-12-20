package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.AdminUserRole;

import java.util.List;

public interface AdminRoleMapper {
    List<AdminUserRole> getAdminUserRoleByAdminId(Integer adminId);
}
