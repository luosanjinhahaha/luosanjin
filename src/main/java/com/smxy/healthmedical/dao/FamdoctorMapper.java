package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.Famous_Doctor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface FamdoctorMapper {
	List<Famous_Doctor> famdoctorlist();
}
