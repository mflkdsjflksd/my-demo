package com.rabbitMQ.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: xs
 * @describe:生产者
 * @date 2022/3/14 14:10
 */
public class Producer {
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("81.68.219.116");
        factory.setUsername("admin");
        factory.setPassword("xushan00");

        try {
            //创建链接
            Connection connection = factory.newConnection();
            //创建信道
            Channel channel = connection.createChannel();
            /**
             * 参数列表：
             * 1、队列名称，
             * 2、是否持久化，
             * 3、是否进行消息共享
             * 4、是否自动删除(当最后一个消费者断开连接后，是否自动删除队列)
             * 5、其他参数
             */
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            /**
             * 发送一个消息：
             *  1、发送到哪个交换机
             *  2、路由的key值是哪个 本次的队列名称
             *  3、其他参数信息
             *  4、发送消息的消息体
             */
            String message = "hello world";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("消息发送完成");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
