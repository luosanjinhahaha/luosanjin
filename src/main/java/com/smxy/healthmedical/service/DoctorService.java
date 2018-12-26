package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.Doctor;
import com.smxy.healthmedical.bean.DoctorRole;
import com.smxy.healthmedical.bean.Permission;
import com.smxy.healthmedical.bean.Role;

import java.util.List;

public interface DoctorService {

    /*根据id查找医生信息*/
    List<Doctor> getDoctorsByDoctorId(Integer id);

    /*查询医生所有信息带文章*/
    List<Doctor> getDoctorsInfoAll();

    /*查询出所有医生信息*/
    List<Doctor> getDoctorsAll();

    /*根据医师id查询出医师发布的小贴士*/
    List<Doctor> getDoctorTipsByDoctorId(Integer doctorId);

    /*根据医师id查找出医师角色权限*/
    List<Doctor> getDoctorPermissionByRoleId(Integer roleId);

    /*根据医师id查出医师的角色*/
    List<Role> getDoctorRoles(Integer doctorId);

    /*根据医师id查出医师的角色*/
    List<Permission> verifyDoctorPermission(Integer doctorId);
}
