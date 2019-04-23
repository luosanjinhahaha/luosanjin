package com.smxy.healthmedical.utils;

import com.rabbitmq.client.*;
import com.smxy.healthmedical.bean.DoctorAppoint;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "${spring.rabbitmq.queue}", containerFactory = "rabbitListenerContainerFactory")
public class RabbitMQReceiver {

    private final RabbitTemplate rabbitTemplate;
    private final ConnectionFactory connectionFactory;

    @Value("${spring.rabbitmq.queue}")
    private String queue;

    @Autowired
    public RabbitMQReceiver(RabbitTemplate rabbitTemplate, ConnectionFactory connectionFactory) {
        this.rabbitTemplate = rabbitTemplate;
        this.connectionFactory = connectionFactory;
    }

    public void receiver() throws InterruptedException, IOException {
        Channel channel = connectionFactory.createConnection().createChannel(false);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "utf-8");
                System.out.println(message);
            }
        };
        channel.basicConsume(queue,true, consumer);
    }
}
