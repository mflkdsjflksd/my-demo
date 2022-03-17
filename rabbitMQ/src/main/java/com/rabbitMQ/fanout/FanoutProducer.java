package com.rabbitMQ.fanout;

import com.rabbitMQ.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.util.Scanner;

/**
 * @Author: xs
 * @describe: 消费方
 * @date 2022/3/16 16:21
 */
public class FanoutProducer {
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare("logs", "fanout");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String message = scanner.next();
            channel.basicPublish("logs", "", null, message.getBytes());
        }
    }
}
