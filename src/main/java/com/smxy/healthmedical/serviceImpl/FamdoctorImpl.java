package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.bean.Famous_Doctor;
import com.smxy.healthmedical.dao.FamdoctorMapper;
import com.smxy.healthmedical.service.FamdoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamdoctorImpl implements FamdoctorService {
	@Autowired
	FamdoctorMapper famdoctorMapper;
//	@Autowired
//	StringRedisTemplate stringRedisTemplate;
	@Override
	public List<Famous_Doctor> getAll() {
		System.out.println("还是从数据库查询！");
		List<Famous_Doctor> doctors = famdoctorMapper.famdoctorlist();
//		stringRedisTemplate.opsForValue().append("doctors", String.valueOf(doctors));
		return doctors;
	}

}
