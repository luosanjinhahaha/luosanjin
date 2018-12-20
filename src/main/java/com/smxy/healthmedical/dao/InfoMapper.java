package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.Info;
import com.smxy.healthmedical.bean.InfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface InfoMapper {
    long countByExample(InfoExample example);

    int deleteByExample(InfoExample example);

    int deleteByPrimaryKey(Integer pinfoId);

    int insert(Info record);

    int insertSelective(Info record);

    List<Info> selectByExample(InfoExample example);

    Info selectByPrimaryKey(Integer pinfoId);
    
    List<Info> selectByExampleWithDept(InfoExample example);
    
    List<Info> selectAllWithDept(Info info);

    Info selectByPrimaryKeyWithDept(Integer pinfoId);
    
    /*带部门有选择的模糊连表查询*/
//    List<Info> selectByExampleDimWithDept(InfoExample example);

    int updateByExampleSelective(@Param("record") Info record, @Param("example") InfoExample example);

    int updateByExample(@Param("record") Info record, @Param("example") InfoExample example);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);

	Integer[] countInfoPiId();

	/*根据所属部门id查找患者*/
    List<Info> selectInfoByPiId(Integer piId);

}