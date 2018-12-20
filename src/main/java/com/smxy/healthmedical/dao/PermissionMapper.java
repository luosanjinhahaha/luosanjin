package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.Permission;

import java.util.List;

public interface PermissionMapper {
    /*通过 permissionId 查找 权限*/
    Permission getDoctorPermissionByPermissionId(Integer permissionId);

    /*通过 permissionName 查找 权限*/
    Permission getDoctorPermissionByPermissionName(String permissionName);

    /*查找所有权限*/
    List<Permission> getDoctorPermissionAll();
}
