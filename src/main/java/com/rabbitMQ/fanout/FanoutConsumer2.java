package com.rabbitMQ.fanout;

import com.rabbitMQ.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

/**
 * @Author: xs
 * @describe: 消费者
 * @date 2022/3/16 16:20
 */
public class FanoutConsumer2 {
    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare("logs", "fanout");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, "logs", "");

        DeliverCallback deliverCallback = (consumer, message) -> {
            System.out.println("queueName2" + new String(message.getBody()));
        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }
}
