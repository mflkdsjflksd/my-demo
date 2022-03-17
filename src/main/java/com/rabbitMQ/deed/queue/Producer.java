package com.rabbitMQ.deed.queue;

import com.rabbitMQ.utils.RabbitMqUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;

import java.util.Scanner;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/16 22:41
 */
public class Producer {
    public static final String EXCHANGE_NAME = "normal_exchange";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        //AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().expiration("10000").build();
        for (int i = 0; i < 10; i++) {
            String str = "info" + i;
            channel.basicPublish(EXCHANGE_NAME, "zhangsan", null, str.getBytes());
        }
    }
}
