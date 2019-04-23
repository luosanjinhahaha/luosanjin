package com.smxy.healthmedical.serviceImpl.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.smxy.healthmedical.bean.FastDfsDoc;
import com.smxy.healthmedical.bean.PushContent;
import com.smxy.healthmedical.dao.FastDfsDocMapper;
import com.smxy.healthmedical.dao.PushContentMapper;
import com.smxy.healthmedical.service.websocket.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author Luoxin
 * Date 2018/12/22
 * Time 18:15
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final FastDfsDocMapper fastDfsDocMapper;
    private final PushContentMapper pushContentMapper;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public SubscriptionServiceImpl(FastDfsDocMapper fastDfsDocMapper, PushContentMapper pushContentMapper, SimpMessagingTemplate simpMessagingTemplate) {
        this.fastDfsDocMapper = fastDfsDocMapper;
        this.pushContentMapper = pushContentMapper;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    private final String HTTP = "http://106.14.160.207:8888/";

    @Override
    public FastDfsDoc getFastDfsDocPathByInPath(Integer id) {
        return fastDfsDocMapper.getFastDfsDocInfoByInPath(id);
    }

    /**
     * 推送文章实现方法
     * @param pushId 推送指定文章id
     */
    @Override
    public void getContentByPushId(String pushId) {
        JSONObject jsonObject = JSONObject.parseObject(pushId);
        String content = jsonObject.get("content").toString();
        System.out.println("content:" + content);
        PushContent pushContent = pushContentMapper.selectPushContentByPushId(content);
        simpMessagingTemplate.convertAndSend("/push/article",pushContent);
    }

    /**
     * 推送方案实现方法
     * @param docId 推送方案id
     */
    @Override
    public void getDocByDocId(String docId) {
        JSONObject jsonObject = JSONObject.parseObject(docId);
        String plans = jsonObject.get("docId").toString();
        System.out.println(docId);
        FastDfsDoc fastDfsDoc = fastDfsDocMapper.selectPushDocByDocId(plans);
        simpMessagingTemplate.convertAndSend("/push/doc", fastDfsDoc);
    }

    /**
     * 批量推送
     * @param id
     */
    @Override
    public void getDocByDocIds(String id) {
        List<FastDfsDoc> fastDfsDocs = fastDfsDocMapper.selectPushDocsByDocIds(id);
        simpMessagingTemplate.convertAndSend("/push/docs", fastDfsDocs);
    }

    /**
     *
     * @param customDetails 定制的患病名称
     */
    @Override
    public void getCustomDetails(String customDetails) {
        List<FastDfsDoc> details = fastDfsDocMapper.selectCustomDetails(customDetails);
        for (FastDfsDoc fastDfsDoc : details) {
            fastDfsDoc.setDocPath(HTTP  + fastDfsDoc.getDocPath());
        }
        simpMessagingTemplate.convertAndSend("/push/customDetails", details);
    }
}
