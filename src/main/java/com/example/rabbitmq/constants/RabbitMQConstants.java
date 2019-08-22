package com.example.rabbitmq.constants;

public class RabbitMQConstants {

    /**
     * 四种模式：
     *
     * Direct  直接用队列的名字来进行绑定，实现点对点的消息传输
     *
     * Topic   根据Config中设置的RoutineKey还有发送消息时候的topic来判断是否会传输。
     *
     * Fanout  类似于广播，不用设置路由，只要发送消息设置了对应的Exchange就可以对该Exchange中的接收者进行广播
     *
     * Header  Headers是一个键值对，可以定义成 Hashtable。发送者在发送的时候定义一些键值对，接收者也可以再绑定时候传入一些键值对，两者匹配的话，则对应的队列就可以收到消息。匹配有两种方式all和any
     */

    /**
     * Direct模式-对应调用处使用
     */
    public static final String MY_FIRST_QUEUE = "My-First-Queue";

    /**
     * Direct模式-对应调用处使用
     */
    public static final String TOPIC_QUEUE_1 = "Topic_Queue_One";

    public static final String TOPIC_QUEUE_2 = "Topic_Queue_Two";

    public static final String TOPIC_EXCHANGE = "Topic_Exchange";

    public static final String ROUTINE_KEY_1 = "Topic.Key1";
    // 可以使用通配符Topic.*
    public static final String ROUTINE_KEY_2 = "Topic.Key2";




}