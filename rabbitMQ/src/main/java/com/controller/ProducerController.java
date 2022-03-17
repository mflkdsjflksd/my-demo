package com.controller;

import com.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/17 18:46
 */
@Slf4j
@RequestMapping("/confirm")
@RestController
public class ProducerController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("sendMessage")
    public void setMessage(String message) {
        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE_NAME, "key1");
        log.info("发送消息的内容：{}" + message);
    }
}
