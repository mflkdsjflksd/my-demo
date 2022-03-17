package com.rabbitMQ.utils;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/15 16:42
 */
public class RabbitMqUtils {

    public static final String QUEUE_NAME = "hello xushan";

    public static Channel getChannel() {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("81.68.219.116");
        factory.setUsername("admin");
        factory.setPassword("xushan00");
        //创建链接
        Connection connection = null;
        try {
            connection = factory.newConnection();
            //创建信道
           Channel channel = connection.createChannel();
            return channel;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }
}

