package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionService {

    /*通过角色id获取医师权限*/
    List<RolePermission> getDoctorPermissionByRoleId(Integer roleId);

    /*查找医师所有权限*/
    List<RolePermission> getDoctorPermissionAll();

    /*通过角色id权限id添加医师权限*/
    void addDoctorPermission(RolePermission rolePermission);

    /*通过角色id和权限id数组批量添加医师权限*/
    void addDoctorPermissions(Integer roleId, List<Integer> permissionId);

    /*通过角色id权限id删除医师权限*/
    void deleteDoctorPermission(RolePermission rolePermission);

    /*批量删除医师权限*/
    void deleteDoctorPermissions(Integer roleId, List<Integer> permissionId);
}
