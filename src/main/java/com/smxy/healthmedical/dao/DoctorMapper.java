package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.Doctor;
import com.smxy.healthmedical.bean.DoctorRole;
import com.smxy.healthmedical.bean.Permission;
import com.smxy.healthmedical.bean.Role;

import javax.print.Doc;
import java.util.List;

/**
 *
 * 功能描述:医生表btl_doctor操作
 * @author luoxin
 */
public interface DoctorMapper {

    /*根据id查找医生信息*/
    List<Doctor> getDoctorById(Integer doctorId);

    /*查询医生所有信息带文章*/
    List<Doctor> getDoctorAllWithTips();

    /*查询出所有医生信息*/
    List<Doctor> getDoctorAll();

    List<Doctor> getPuWaiDor();

    /*根据医师id查询出医师发布的小贴士*/
    List<Doctor> selectDoctorTipsByDoctorId(Integer doctorId);

   /*根据医师id查出医师的角色*/
    List<DoctorRole> getDoctorRolesByDoctorId(Integer doctorId);

    /*根据医师id查出医师的角色为查询权限*/
    List<Permission> getDoctorRolesByDoctorIdForPermission(Integer doctorId);

}