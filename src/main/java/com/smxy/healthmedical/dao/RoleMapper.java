package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.Role;

public interface RoleMapper {
    /*通过 roleId 查找角色*/
    Role getDoctorRoleByRoleId(Integer roleId);

    /*通过 RoleName 查找角色*/
    Role getDoctorRoleByRoleName(String roleName);
}
