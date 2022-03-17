package com.rabbitMQ.发布确认;

import com.rabbitMQ.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;

import java.io.IOException;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/16 11:44
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        channel.queueDeclare(RabbitMqUtils.QUEUE_NAME, true, false, false, null);
        channel.basicQos(1);
        channel.confirmSelect();
        //single(channel);
        batch(channel);
        //async(channel);
    }

    //单个发布确认模式
    public static void single(Channel channel) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        int length = 1000, count = 0;
        for (int i = 0; i < length; i++) {
            String message = String.valueOf(i);
            channel.basicPublish("", RabbitMqUtils.QUEUE_NAME, null, message.getBytes());
            boolean b = channel.waitForConfirms();
            if (b) {
                count++;
            }
        }
        System.out.println("时间：" + (System.currentTimeMillis() - start) + "次数：" + count);
    }

    public static void batch(Channel channel) throws InterruptedException, IOException {
        long start = System.currentTimeMillis();
        int length = 1000, count = 0;
        for (int i = 0; i < length; i++) {
            String message = String.valueOf(i);
            channel.basicPublish("", RabbitMqUtils.QUEUE_NAME, null, message.getBytes());
            if (i % 100 == 0) {
                boolean b = channel.waitForConfirms();
                if (b) {
                    count += 100;
                }
            }
        }
        System.out.println("时间：" + (System.currentTimeMillis() - start) + "次数：" + count);
    }

    public static void async(Channel channel) throws Exception {

        ConcurrentSkipListMap<Long, String> outstandingConfirms = new
                ConcurrentSkipListMap<>();


        //消息成功回调函数
        ConfirmCallback ackCallback = (deliveryTag, multiple) -> {
            outstandingConfirms.remove(deliveryTag);
            System.out.println("确认的消息" + deliveryTag);
        };
        //消息失败回调函数
        ConfirmCallback nAckCallback = (deliveryTag, multiple) -> {
            System.out.println("未确认的消息" + deliveryTag);
        };

        channel.addConfirmListener(ackCallback, nAckCallback);
        long start = System.currentTimeMillis();
        int length = 1000, count = 0;
        for (int i = 0; i < length; i++) {
            String message = String.valueOf(i);
            channel.basicPublish("", RabbitMqUtils.QUEUE_NAME, null, message.getBytes());
            if (i % 100 == 0) {
                boolean b = channel.waitForConfirms();
                if (b) {
                    count += 100;
                }
            }
        }
        System.out.println("时间：" + (System.currentTimeMillis() - start) + "次数：" + count);
    }

}
