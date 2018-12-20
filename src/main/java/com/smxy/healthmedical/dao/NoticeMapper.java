package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface NoticeMapper {
	List<Notice> selectAll();
	void deleteByPrimaryKey(Integer id);
	Notice selectByPrimaryKey(Integer id);
	void updateByPrimarySelective(Notice record);
}
