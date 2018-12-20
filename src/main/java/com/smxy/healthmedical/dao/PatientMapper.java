package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.Patient;
import com.smxy.healthmedical.bean.PatientExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientMapper {
    long countByExample(PatientExample example);

    int deleteByExample(PatientExample example);

    int deleteByPrimaryKey(Integer patientId);

    int insert(Patient record);

    int insertSelective(Patient record);

    List<Patient> selectByExample(PatientExample example);

    Patient selectByPrimaryKey(Integer patientId);
    
    List<Patient> selectByExampleWithDept(PatientExample example);

    Patient selectByPrimaryKeyWithDept(Integer patientId);

    int updateByExampleSelective(@Param("record") Patient record, @Param("example") PatientExample example);

    int updateByExample(@Param("record") Patient record, @Param("example") PatientExample example);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);
}