package com.example.rabbitmq.component;

import com.example.rabbitmq.constants.RabbitMQConstants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RabbitMQConsumeService {

    /**
     * 消费
     * @param list
     */
    @RabbitListener(queues = RabbitMQConstants.MY_FIRST_QUEUE)
    public void consumeFirstMQueue(List list){
        System.out.println("第一消息队列Direct模式处理"+list.toString());
    }

    /**
     * Direct模式
     */
    @RabbitListener(queues = RabbitMQConstants.TOPIC_QUEUE_1)
    public void receiveTopicOne(List list){
        System.out.println("Topic模式下的第一个队列处理"+list);
    }

    @RabbitListener(queues = RabbitMQConstants.TOPIC_QUEUE_2)
    public void receiveTopicTwo(List list){
        System.out.println("Topic模式下的第二个（通配符）队列处理"+list);
    }

}
