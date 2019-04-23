package com.smxy.healthmedical.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class RabbitMQMonitorUtils {

    private static final String QUEUENAME = "appoint";

    private static final String URI = "amqp://guest:guest@106.14.160.207:5672";

    public void monitor() throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setUri(URI);

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        System.out.println(channel.getChannelNumber() + "\t" + channel.consumerCount(QUEUENAME));

        channel.close();

        connection.close();
    }
}
