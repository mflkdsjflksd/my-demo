package com.rabbitMQ.direct;

import com.rabbitMQ.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.util.Scanner;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/16 21:38
 */
public class Task {
    public static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String message = scanner.next();
            channel.basicPublish(EXCHANGE_NAME, message, null, message.getBytes());
        }
    }
}
