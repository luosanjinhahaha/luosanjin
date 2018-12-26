package com.smxy.healthmedical.controller.websocket;

import com.smxy.healthmedical.service.websocket.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

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

}
