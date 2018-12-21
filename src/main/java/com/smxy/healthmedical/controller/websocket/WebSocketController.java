package com.smxy.healthmedical.controller.websocket;

import com.smxy.healthmedical.service.websocket.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * Created with IDEA
 *
 * @author Luoxin
 * Date 2018/12/20
 * Time 21:24
 */
@Controller
public class WebSocketController {

    private final WebSocketService webSocketService;

    @Autowired
    public WebSocketController(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }


    /**
     * Scheduled(fixedRate = 3000) 注解修饰的方法不能带参数
     */
    @MessageMapping("/socket/schedule/push")
    @Scheduled(fixedRate = 3000)
    public void sendServerInfo(){
        webSocketService.sendServerInfo();
    }
}
