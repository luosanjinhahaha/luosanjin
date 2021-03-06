package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.FastDfsDoc;
import com.smxy.healthmedical.bean.FastDfsImg;

import java.util.List;

public interface FastDfsDocMapper {

    /*获取所有fastDFS文档路径*/
    List<FastDfsDoc> getDocPath();

    /*插入文档路径*/
    void insertDocPath(FastDfsDoc fastDfsDoc);

    /*删除文档路径*/
    void deleteDoc(String oldPath);

    /*根据路径参数查出文档信息*/
    FastDfsDoc getFastDfsDocInfoByInPath(Integer id);

    /**
     * 根据id查询治疗方案
     * @param docId 方案id
     */
    FastDfsDoc selectPushDocByDocId(String docId);

    List<FastDfsDoc> selectPushDocsByDocIds(String id);

    List<FastDfsDoc> selectCustomDetails(String customDetails);
}
