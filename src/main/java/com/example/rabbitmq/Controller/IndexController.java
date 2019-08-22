package com.example.rabbitmq.Controller;

import com.example.rabbitmq.constants.RabbitMQConstants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("index")
public class IndexController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @ResponseBody
    @RequestMapping("/firstQueue")
    public Map sendDirectQueue(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<String> list  = new ArrayList<String>();
        list.add("FIRST");
        list.add("MQ");
        list.add("QUEUE");
        amqpTemplate.convertAndSend(RabbitMQConstants.MY_FIRST_QUEUE,list);
        modelMap.put("msg","控制台打印消费信息");
        return modelMap;
    }

    @ResponseBody
    @RequestMapping("/firstTopicQueue")
    public Map sendTopicQueue(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<String> list  = new ArrayList<String>();
        list.add("FIRST QUERY Topic Model");
        amqpTemplate.convertAndSend(RabbitMQConstants.TOPIC_EXCHANGE,"Topic.key1",list+"FirstList");
        amqpTemplate.convertAndSend(RabbitMQConstants.TOPIC_EXCHANGE, "Topic.key2", list + "SecondList");
        modelMap.put("msg","控制台打印消费信息");
        return modelMap;
    }
}
