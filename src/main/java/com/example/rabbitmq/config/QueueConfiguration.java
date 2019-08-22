package com.example.rabbitmq.config;

import com.example.rabbitmq.constants.RabbitMQConstants;
import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 队列注入Spring IOC
 */
@Configuration
public class QueueConfiguration {

    /**
     * Direct模式
     */
    @Bean
    public Queue getFirstQueue(){
        return new Queue(RabbitMQConstants.MY_FIRST_QUEUE,true);
    }

    /**
     * Topic模式 根据RoutineKey去绑定接收的消息
     */
    @Bean
    public Queue topicQueueOne(){
        return new Queue(RabbitMQConstants.TOPIC_QUEUE_1,true);
    }

    @Bean
    public Queue topicQueueTwo(){
        return new Queue(RabbitMQConstants.TOPIC_QUEUE_2,true);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(RabbitMQConstants.TOPIC_EXCHANGE);
    }

    @Bean
    public Binding topicBindingOne(){
        return BindingBuilder.bind(topicQueueOne()).to(topicExchange()).with(RabbitMQConstants.ROUTINE_KEY_1);
    }

    @Bean
    public Binding topicBindingTwo(){
        return BindingBuilder.bind(topicQueueTwo()).to(topicExchange()).with(RabbitMQConstants.ROUTINE_KEY_2);
    }


}
