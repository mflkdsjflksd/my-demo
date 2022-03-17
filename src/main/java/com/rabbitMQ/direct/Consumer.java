package com.rabbitMQ.direct;

import com.rabbitMQ.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/16 18:33
 */
public class Consumer {
    private static final String EXCHANGE_NAME = "direct_logs";
    private static final String QUEUE_NAME = "console";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        //参数一：绑定交换机；参数二：交换机类型
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        //参数一：队列名称，             参数二：是否持久化，            参数三：是否进行消息共享；
        //参数四：是否自动删除(当最后一个消费者断开连接后，是否自动删除队列)  参数五：其他参数
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //绑定队列：参数一：队列名称；参数二：交换机名；参数三：路由key
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "info");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "warning");

        //成功函数回调
        DeliverCallback deliverCallback = (consumer, message) -> {
            System.out.println("console：" + new String(message.getBody()));
        };
        //失败函数回调
        CancelCallback callback = (cancelCallbackTag) -> {
            System.out.println(cancelCallbackTag);
        };
        //参数一：队列名 参数二：是否自动应答；参数三：回调函数；参数四：失败的回调函数
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, callback);
    }
}
