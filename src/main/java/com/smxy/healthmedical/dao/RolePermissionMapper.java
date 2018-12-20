package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionMapper {

    /*通过角色id查出医师权限*/
    List<RolePermission> getDoctorPermissionByRoleId(Integer roleId);

    /*查出医师所有权限*/
    List<RolePermission> getDoctorPermissionAll();

    /*通过角色id权限id添加医师权限*/
    void addDoctorPermissionByDoctorRoleIdAndPermissionId(RolePermission rolePermission);

    /*通过角色id和权限id数组批量添加医师权限*/
    void addDoctorPermissionBatch(@Param("roleId") Integer roleId, @Param("permissionId") List<Integer> permissionId);

    /*通过角色id权限id删除医师权限*/
    void deleteDoctorPermissionByPermissionId(RolePermission rolePermission);

    /*通过角色id和权限id数组批量删除医师权限*/
    void deleteDoctorPermissionBatch(@Param("roleId") Integer roleId, @Param("permissionId") List<Integer> permissionId);
}
