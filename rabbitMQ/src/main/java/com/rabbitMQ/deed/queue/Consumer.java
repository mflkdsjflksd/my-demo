package com.rabbitMQ.deed.queue;

import com.rabbitMQ.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xs
 * @describe:普通交换机
 * @date 2022/3/16 22:42
 */
public class Consumer {
    //普通交换机名称
    private static final String NORMAL_EXCHANGE = "normal_exchange";
    //死信交换机名称
    private static final String DEAD_EXCHANGE = "dead_exchange";
    public static void main(String[] argv) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        //声明死信和普通交换机 类型为 direct
        channel.exchangeDeclare(NORMAL_EXCHANGE, BuiltinExchangeType.DIRECT);
        channel.exchangeDeclare(DEAD_EXCHANGE, BuiltinExchangeType.DIRECT);
        //声明死信队列
        String deadQueue = "dead-queue";
        channel.queueDeclare(deadQueue, false, false, false, null);
        //死信队列绑定死信交换机与 routingkey
        channel.queueBind(deadQueue, DEAD_EXCHANGE, "lisi");
        //正常队列绑定死信队列信息
        Map<String, Object> params = new HashMap<>();
        //正常队列设置死信交换机 参数 key 是固定值
        params.put("x-dead-letter-exchange", DEAD_EXCHANGE);
        //正常队列设置死信 routing-key 参数 key 是固定值
        params.put("x-dead-letter-routing-key", "lisi");
        //params.put("x-max-length", 6);
        String normalQueue = "normal-queue";
        channel.queueDeclare(normalQueue, false, false, false, params);

        channel.queueBind(normalQueue, NORMAL_EXCHANGE, "zhangsan");
        System.out.println("等待接收消息........... ");

        DeliverCallback deliverCallback = (consumerTag, message) -> {
            String mes = new String(message.getBody(), "UTF-8");
            if (mes.equals("info5")) {
                //是否从新放回队列，不放回
                channel.basicReject(message.getEnvelope().getDeliveryTag(), false);
                return;
            }
            System.out.println("Consumer01 接收到消息" + mes);
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
        };
        channel.basicConsume(normalQueue, false, deliverCallback, consumerTag -> {
        });
    }
}
