package com.controller;

import com.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @Author: xs
 * @describe: 发送消息
 * @date 2022/3/17 13:03
 */
@Slf4j
@RestController
@RequestMapping("ttl")
public class SendMessage {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("sendMessage")
    public void sendMessage(String message) {
        log.info("当前时间:{},发送一条消息给两个ttl队列:{}", LocalDateTime.now(), new String(message.getBytes()));
        rabbitTemplate.convertAndSend("X", "XA", "消息来自ttl为10s的队列：" + message);
        rabbitTemplate.convertAndSend("X", "XB", "消息来自ttl为40s的队列：" + message);
    }

    @RequestMapping("sendMessageExpire")
    public void sendMessageExpire(String message, String ttlTime) {
        log.info("当前时间:{},发送一条消息给两个ttl队列:{};时长：{}", LocalDateTime.now(), new String(message.getBytes()), ttlTime);
        rabbitTemplate.convertAndSend("X", "XC", message, (msg) -> {
            msg.getMessageProperties().setExpiration(ttlTime);
            return msg;
        });
    }

    @RequestMapping("sendDelayMessageExpire")
    public void sendDelayMessageExpire(String message, Integer ttlTime) {
        log.info("当前时间:{},发送一条消息给两个ttl队列:{};时长：{}", LocalDateTime.now(), new String(message.getBytes()), ttlTime);
        rabbitTemplate.convertAndSend(DelayedQueueConfig.DELAYED_EXCHANGE_NAME, DelayedQueueConfig.DELAYED_ROUTING_KEY, message, msg -> {
            msg.getMessageProperties().setDelay(ttlTime);
            return msg;
        });
    }
}
