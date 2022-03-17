package com.consumer;

import com.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * @Author: xs
 * @describe: 基于插件的延迟消息
 * @date 2022/3/17 17:10
 */
@Slf4j
@Configuration
public class DelayQueueConsumer {
    @RabbitListener(queues = DelayedQueueConfig.DELAYED_QUEUE_NAME)
    public void receiveDelayQueue(Message message) {
        String msg = new String(message.getBody());
        log.info("当前时间：{}，收到延迟队列的消息：{}", LocalDateTime.now(), msg);
    }
}
