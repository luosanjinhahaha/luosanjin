package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.Permission;
import com.smxy.healthmedical.dao.PermissionMapper;
import com.smxy.healthmedical.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * @author Luoxin
 * Date 2018/12/13
 * Time 19:04
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPermissionAll() {
        return permissionMapper.getDoctorPermissionAll();
    }
}
