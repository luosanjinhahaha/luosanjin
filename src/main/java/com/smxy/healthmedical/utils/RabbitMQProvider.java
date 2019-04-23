package com.smxy.healthmedical.utils;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProvider {
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange directExchange;
    @Autowired
    public RabbitMQProvider(RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    public void sender(Object object) {
        rabbitTemplate.convertAndSend(directExchange.getName(), "appoint", object);
        System.out.println("message send success!");
    }
}
