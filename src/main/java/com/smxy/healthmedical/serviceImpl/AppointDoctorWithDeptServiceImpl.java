package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.Department;
import com.smxy.healthmedical.dao.AppointDoctorWithDeptMapper;
import com.smxy.healthmedical.service.AppointDoctorWithDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 * @author:Luoxin
 * Date:2018/10/25
 * Time:15:30
 */
@Service
public class AppointDoctorWithDeptServiceImpl implements AppointDoctorWithDeptService {
    @Autowired
    AppointDoctorWithDeptMapper appointDoctorWithDeptMapper;
    @Override
    public Department getDeptAll(Integer id) {
        return appointDoctorWithDeptMapper.getAppointDoctorWithDept(id);
    }
}
