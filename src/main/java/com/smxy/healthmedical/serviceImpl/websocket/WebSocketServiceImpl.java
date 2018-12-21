package com.smxy.healthmedical.serviceImpl.websocket;
import com.smxy.healthmedical.model.OutMessage;
import com.smxy.healthmedical.service.websocket.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 * @author Luoxin
 * Date 2018/12/20
 * Time 21:31
 */
@Service
public class WebSocketServiceImpl implements WebSocketService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public WebSocketServiceImpl(SimpMessagingTemplate simpMessagingTemplate) {

        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Override
    public void sendServerInfo() {

        int processors = Runtime.getRuntime().availableProcessors();

        Long freeMem = Runtime.getRuntime().freeMemory();

        Long maxMem = Runtime.getRuntime().maxMemory();

        String message = String.format("服务器可用处理器:%s; 虚拟机空闲内容大小: %s; 最大内存大小: %s", processors,freeMem,maxMem );

        simpMessagingTemplate.convertAndSend("/topic/server_info",new OutMessage(message));
    }
}
