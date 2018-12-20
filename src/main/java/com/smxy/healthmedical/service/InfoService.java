package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.Info;

import java.util.List;

public interface InfoService {
	/*查出所有患者信息*/
	List<Info> getAll();

	/*患者保存*/
	void savePatients(Info info);

	//检验患者名字是否重复
	//当前数据库没有这条数据则返回0表示
	boolean checkpatients(String pinfoName);

	Info getPatients(Integer id) ;

	Info UpdatePatients(Info info);
	void delPatientsById(Integer id);

	//批量删除
	void deleteBatch(List<Integer> ids) ;

	//快速搜索患者
	List<Info> searchPatients(Info info, String search);

	Integer[] getAllInfoPiId();

	List<Info> getInfoByPiId(Integer piId);
}
