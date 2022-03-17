package com.consumer;

import com.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/17 18:52
 */
@Configuration
@Slf4j
public class ConfirmConsumer {
    @RabbitListener(queues = ConfirmConfig.CONFIRM_QUEUE_NAME)
    public void receiveConfirmMessage(Message message) {
        log.info("接受的的队列confim.queue的消息:{}", new String(message.getBody()));
    }
}
