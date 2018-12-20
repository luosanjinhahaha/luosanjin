package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.DoctorRole;

import java.util.List;

public interface DoctorRoleMapper {

    /*通过医师角色id查找医师角色id*/
    DoctorRole getDoctorRoleIdByDoctorId(Integer doctorId);

    /*通过医师角色id查找医师角色*/
    DoctorRole getDoctorRoleByDoctorRoleId(Integer doctorRoleId);

    /**/
    List<DoctorRole> getDoctorRoleByDoctorId(Integer doctorId);
}
