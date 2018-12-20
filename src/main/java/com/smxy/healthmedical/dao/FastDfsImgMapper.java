package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.FastDfsImg;

import java.util.List;

public interface FastDfsImgMapper {
    List<FastDfsImg> getImgPath();
    void insertImgPath(FastDfsImg fastDfsImg);
    void deleteImg(String oldPath);
}
