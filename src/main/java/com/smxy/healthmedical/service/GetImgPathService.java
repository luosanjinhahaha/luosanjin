package com.smxy.healthmedical.service;

import com.smxy.healthmedical.bean.FastDfsImg;

import java.util.List;

public interface GetImgPathService {
    List<FastDfsImg> getImgPathAll();
    void ImgPath(FastDfsImg fastDfsImg);
    void deleteImgByPath(String oldPath);
}
