package com.smxy.healthmedical.service.websocket;

import com.smxy.healthmedical.bean.FastDfsDoc;

import java.util.List;

public interface SubscriptionService {

    FastDfsDoc getFastDfsDocPathByInPath(Integer id);

    /**
     * 推送文章接口
     * @param pushId 推送指定文章id
     */
    void getContentByPushId(String pushId);

    /**
     * 推送治疗方案接口
     * @param docId 推送方案id
     */
    void getDocByDocId(String docId);

    /**
     *
     * @param id
     */
    void getDocByDocIds(String id);

    /**
     *
     * @param customDetails 定制的患病名称
     */
    void getCustomDetails(String customDetails);
}
