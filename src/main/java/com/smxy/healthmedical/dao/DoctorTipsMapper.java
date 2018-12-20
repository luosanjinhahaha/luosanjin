package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.DoctorTips;

import java.util.List;

public interface DoctorTipsMapper {
    List<DoctorTips> getDoctortTipsBydoctorTipsDoctorId(Integer doctorTipsDoctorId);
}
