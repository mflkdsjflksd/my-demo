package com.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xs
 * @describe: 具有过期时间的队列
 * @date 2022/3/17 12:29
 */
@Configuration
public class TtlQueueConfig {
    public final String X_EXCHANGE = "X";
    public final String QUEUE_A = "QA";
    public final String QUEUE_B = "QB";
    public final String Y_DEAD_LETTER_EXCHANGE = "Y";
    public final String DEAD_LETTER_QUEUE = "QD";
    public final String QUEUE_C = "QC";

    @Bean
    public Queue queueC() {
        HashMap<String, Object> arguments = new HashMap<>();
        //声明当前队列绑定的死信交换机
        arguments.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        //声明当前队列的死信路由 key
        arguments.put("x-dead-letter-routing-key", "YD");
        //声明队列的 TTL
        arguments.put("x-message-ttl", 10000);
        return QueueBuilder.durable(QUEUE_C).withArguments(arguments).build();
    }

    @Bean
    public Binding queueCBindingX() {
         return BindingBuilder.bind(queueC()).to(xExchange()).with("XC");
    }

    @Bean
    public DirectExchange xExchange() {
        return new DirectExchange(X_EXCHANGE);
    }

    @Bean
    public DirectExchange yExchange() {
        return new DirectExchange(Y_DEAD_LETTER_EXCHANGE);
    }


    @Bean
    public Queue queueA() {
        Map<String, Object> arguments = new HashMap<>();
        //声明当前队列绑定的死信交换机
        arguments.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        //声明当前队列的死信路由 key
        arguments.put("x-dead-letter-routing-key", "YD");
        //声明队列的 TTL
        arguments.put("x-message-ttl", 10000);
        return QueueBuilder.durable(QUEUE_A).withArguments(arguments).build();
    }

    @Bean()
    public Binding queueABindingXExchange() {
        return BindingBuilder.bind(queueA()).to(xExchange()).with("XA");
    }

    @Bean("queueB")
    public Queue queueB() {
        Map<String, Object> arguments = new HashMap<>(3);
        //声明当前队列绑定的死信交换机
        arguments.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        //声明当前队列的死信路由 key
        arguments.put("x-dead-letter-routing-key", "YD");
        //声明队列的 TTL
        arguments.put("x-message-ttl", 40000);
        return QueueBuilder.durable(QUEUE_B).withArguments(arguments).build();
    }

    @Bean()
    public Binding queueBBindingXExchange() {
        return BindingBuilder.bind(queueB()).to(xExchange()).with("XB");
    }

    @Bean()
    public Queue queueD() {
        return new Queue(DEAD_LETTER_QUEUE);
    }

    @Bean()
    public Binding deadQueueBindingXExchange() {
        return BindingBuilder.bind(queueD()).to(yExchange()).with("YD");
    }
}
