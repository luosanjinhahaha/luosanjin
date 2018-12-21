package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.FastDfsDoc;
import com.smxy.healthmedical.bean.FastDfsImg;

import java.util.List;

public interface FastDfsDocMapper {

    List<FastDfsDoc> getDocPath();

    void insertDocPath(FastDfsDoc fastDfsDoc);

    void deleteDoc(String oldPath);

}
