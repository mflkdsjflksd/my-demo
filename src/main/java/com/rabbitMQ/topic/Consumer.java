package com.rabbitMQ.topic;

import com.rabbitMQ.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/16 22:04
 */
public class Consumer {
    public static final String QUEUE_NAME = "queue_1";
    public static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        channel.queueDeclare(QUEUE_NAME, false, false, true, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "*.orange.*");
        DeliverCallback deliverCallback = (tag, message) -> {
            System.out.println("队列1：" + new String(message.getBody()));
        };
        CancelCallback callback = (tag) -> {
            System.out.println(tag);
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, callback);
    }
}
