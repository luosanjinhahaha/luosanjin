package com.smxy.healthmedical.controller.websocket;

import com.alibaba.fastjson.JSONObject;
import com.smxy.healthmedical.service.websocket.SubscriptionService;
import javafx.scene.media.VideoTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * @author Luoxin
 * Date 2018/12/22
 * Time 17:35
 */
@Controller
public class SubscriptionController {
    private final SubscriptionService subscriptionService;
    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @MessageMapping("/topic/subscription")
    @SendTo("/topic/diagnosis")
    public String fastDfsDocInfo(String path){
        return path;
    }

    /**
     * 接收客户端传来的文章id
     * {秒数} {分钟} {小时} {日期} {月份} {星期} {年份(可为空)}
     * @param pushId 推送id
     */
    @MessageMapping("/push/subscription")
    public void pushArticle(String pushId){
        System.out.println("pushId: " + pushId);
        subscriptionService.getContentByPushId(pushId);

    }

    /**
     * 传入方案id查找方案
     * @param docId 推送文章id
     */
    @MessageMapping("/push/plan")
    public void pushPlan(String docId) {
        System.out.println("docId" + docId);
        subscriptionService.getDocByDocId(docId);
    }

    /**
     * 批量推送方案
     * @param docIds 方案ids
     */
    @MessageMapping("/push/plans")
    public void pushPlans(@RequestParam("docIds") String docIds) {
        if (docIds.contains("-")) {
            String[] ids = docIds.split("-");
            for (String id : ids) {
                subscriptionService.getDocByDocIds(id);
            }
        }
    }

    @MessageMapping("/push/treatment")
    public void pushTreatment(String customDetails) {
        System.out.println("customDetails: " + customDetails);
        JSONObject jsonObject = JSONObject.parseObject(customDetails);
        System.out.println(jsonObject.get("customDetails"));
        customDetails = (String) jsonObject.get("customDetails");
        subscriptionService.getCustomDetails(customDetails);
    }
}
