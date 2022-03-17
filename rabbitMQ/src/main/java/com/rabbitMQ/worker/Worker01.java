package com.rabbitMQ.worker;


import com.rabbitMQ.utils.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/15 16:45
 */
public class Worker01 {

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMqUtils.getChannel();
        //不公平分发
        channel.basicQos(1);
        //开启发布确认
        channel.confirmSelect();
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String receivedMessage = new String(delivery.getBody());
            //System.out.println("接收到消息:" + receivedMessage);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println(consumerTag + "消费者取消消费接口回调逻辑");
        };
        System.out.println("C2 消费者启动等待消费.................. ");
        channel.basicConsume(RabbitMqUtils.QUEUE_NAME, false, deliverCallback, cancelCallback);
    }


}

