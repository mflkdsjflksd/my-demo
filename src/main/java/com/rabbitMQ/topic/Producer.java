package com.rabbitMQ.topic;

import com.rabbitMQ.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.util.Scanner;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/16 22:14
 */
public class Producer {
    public static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String message = scanner.next();
            channel.basicPublish(EXCHANGE_NAME, message, null, message.getBytes());
        }
    }
}
