package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.Department;
import com.smxy.healthmedical.dao.DepartmentMapper;
import com.smxy.healthmedical.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DepartmentMapper departmentMapper;
	@Override
	public List<Department> getDepts() {
		List<Department> list = departmentMapper.selectByExample(null);
		return list;
	}
}
