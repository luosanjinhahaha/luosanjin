package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.Media;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface MediaMapper {
	List<Media> selectAll();
	void deleteByPrimaryKey(Integer id);
	Media selectByPrimaryKey(Integer id);
	void updateByPrimarySelective(Media record);
}
