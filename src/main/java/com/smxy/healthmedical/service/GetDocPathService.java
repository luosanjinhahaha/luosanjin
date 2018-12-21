package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.FastDfsDoc;

import java.util.List;

public interface GetDocPathService {

    List<FastDfsDoc> getDocPathAll();

    void DocPath(FastDfsDoc fastDfsDoc);

    void deleteDocByPath(String oldPath);
}
