package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.*;
import com.smxy.healthmedical.dao.DoctorMapper;
import com.smxy.healthmedical.dao.DoctorRoleMapper;
import com.smxy.healthmedical.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * @author Luoxin
 * Date:2018/10/25
 * Time:22:39
 */
@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorMapper doctorMapper;
    private final DoctorRoleMapper doctorRoleMapper;
    @Autowired
    public DoctorServiceImpl(DoctorMapper doctorMapper,DoctorRoleMapper doctorRoleMapper) {
        this.doctorMapper = doctorMapper;
        this.doctorRoleMapper = doctorRoleMapper;
    }

    /*根据id查找医生信息*/
    @Override
    public List<Doctor> getDoctorsByDoctorId(Integer doctorId) {
        return doctorMapper.getDoctorById(doctorId);
    }

    /*查询出所有医生信息*/
    @Override
    public List<Doctor> getDoctorsAll() {
        return doctorMapper.getDoctorAll();
    }

    /*根据医师id查询出医师发布的小贴士*/
    @Override
    public List<Doctor> getDoctorTipsByDoctorId(Integer doctorId) {
        return doctorMapper.selectDoctorTipsByDoctorId(doctorId);
    }

    /*根据医师id查找出医师角色权限*/
    @Override
    public List<Doctor> getDoctorPermissionByRoleId(Integer roleId) {
        return null;
    }

    /*根据医师id查出医师的角色*/
    @Override
    public List<Role> getDoctorRoles(Integer doctorId) {
        List<Role> roles = new ArrayList<>();
        for (DoctorRole doctorRole : doctorRoleMapper.getDoctorRoleByDoctorId(doctorId)) {
            roles.add(doctorRole.getRole());
        }
        return roles;
    }

    /*根据医师id查出医师的角色为查询权限*/
    @Override
    public List<Permission> verifyDoctorPermission(Integer doctorId) {
        List<Permission> permissions = new ArrayList<>();
        for (DoctorRole doctorRole : doctorRoleMapper.getDoctorRoleByDoctorId(doctorId)) {
            for (RolePermission rolePermission : doctorRole.getRole().getRolePermissions()) {
                permissions.add(rolePermission.getPermission());
            }
        }
        return permissions;
    }
}
