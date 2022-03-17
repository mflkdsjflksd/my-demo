package com.rabbitMQ.fanout;

import com.rabbitMQ.utils.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/16 17:08
 */
public class FanoutConsumer1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare("logs", "fanout");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, "logs", "");
        //成功函数回调
        DeliverCallback deliverCallback = (consumer, message) -> {
            System.out.println("queueName1" + new String(message.getBody()));
        };
        CancelCallback callback = (cancelCallbackTag) -> {
            System.out.println(cancelCallbackTag);
        };
        //参数一：队列名 参数二：是否自动应答；参数三：回调函数；参数四：失败的回调函数
        channel.basicConsume(queueName, false, deliverCallback, callback);
        //应答
        channel.confirmSelect();
    }
}
