package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.RolePermission;
import com.smxy.healthmedical.dao.RolePermissionMapper;
import com.smxy.healthmedical.service.RolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * @author Luoxin
 * Date 2018/12/12
 * Time 21:17
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RolePermissionServiceImpl.class);

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Override
    public List<RolePermission> getDoctorPermissionByRoleId(Integer roleId) {
        return rolePermissionMapper.getDoctorPermissionByRoleId(roleId);
    }

    @Override
    public List<RolePermission> getDoctorPermissionAll() {
        return rolePermissionMapper.getDoctorPermissionAll();
    }

    @Override
    public void addDoctorPermission(RolePermission rolePermission) {
        LOGGER.info("=======>" + rolePermission);
        rolePermissionMapper.addDoctorPermissionByDoctorRoleIdAndPermissionId(rolePermission);
    }

    @Override
    public void addDoctorPermissions(Integer roleId, List<Integer> permissionId) {
        rolePermissionMapper.addDoctorPermissionBatch(roleId, permissionId);
    }

    @Override
    public void deleteDoctorPermission(RolePermission rolePermission) {
        rolePermissionMapper.deleteDoctorPermissionByPermissionId(rolePermission);
    }

    @Override
    public void deleteDoctorPermissions(Integer roleId, List<Integer> permissionId) {
        rolePermissionMapper.deleteDoctorPermissionBatch(roleId, permissionId);
    }
}
