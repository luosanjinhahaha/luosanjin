package com.smxy.healthmedical.dao;

import com.smxy.healthmedical.bean.PushContent;

import java.util.List;

public interface PushContentMapper {

    List<PushContent> selectPushContentAll();

    /**
     * 根据传入的文章id查找指定文章
     * @param pushId 文章id
     */
    PushContent selectPushContentByPushId(String pushId);
}
