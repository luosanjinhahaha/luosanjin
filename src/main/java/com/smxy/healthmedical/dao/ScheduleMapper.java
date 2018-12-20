package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.Schedule;
import com.smxy.healthmedical.bean.ScheduleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleMapper {
    long countByExample(ScheduleExample example);

    int deleteByExample(ScheduleExample example);

    int deleteByPrimaryKey(Integer scheduleId);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    List<Schedule> selectByExample(ScheduleExample example);

    Schedule selectByPrimaryKey(Integer scheduleId);

    int updateByExampleSelective(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    int updateByExample(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
}