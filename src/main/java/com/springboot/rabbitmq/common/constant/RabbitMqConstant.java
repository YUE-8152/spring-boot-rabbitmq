package com.springboot.rabbitmq.common.constant;

public class RabbitMqConstant {
    /**
     * direct类型交换机名称
     */
    public final static String DIRECT_EXCHANGE = "direct_exchange";

    /**
     * topic类型交换机名称
     */
    public final static String TOPIC_EXCHANGE = "topic_exchange";

    /**
     * fanout类型默认交换机名称
     */
    public final static String FANOUT_EXCHANGE = "fanout_exchange";

    /**
     * 默认消息队列名称
     */
    public final static String DEFAULT_QUEUE = "default_queue";

    /**
     * 默认路由名称
     */
    public final static String DEFAULT_ROUTING_KEY = "default_routing";

    /**
     * 消息队列名称
     */
    public final static String MSG_QUEUE = "msg_queue";

    /**
     * 消息路由名称
     */
    public final static String MSG_ROUTING_KEY = "msg_routing";

    /**
     * 邮件队列名称
     */
    public final static String EMAIL_QUEUE = "email_queue";

    /**
     * 邮件路由名称
     */
    public final static String EMAIL_ROUTING_KEY = "email_routing";

    /**
     * topic路由名称,匹配以topic_routing开头的所有(如topic_routing.one,topic_routing.one.one)
     * topic.# 匹配所有.后面的所有单词，比如 topic_routing.one 会被该消息队列接受 topic_routing.one.one也会被该消息队列接受
     */
    public final static String TOPIC_ROUTING_ALL_KEY = "topic.#";

    /**
     * topic路由名称，匹配以topic开头的第一个（如topic.one）
     * topic.* 匹配第一个.后面的单词,比如 topic.one 会被该消息队列接受 topic.one.one不会被该消息队列接受
     */
    public final static String TOPIC_ROUTING_ONE_KEY = "topic.*";

    /**
     * fanout队列名称
     */
    public final static String FANOUT_QUEUE = "fanout_queue";

    /**
     * topic.one队列名称
     */
    public final static String TOPIC_ONE_QUEUE = "topic.one";

    /**
     * topic.two队列名称
     */
    public final static String TOPIC_TWO_QUEUE = "topic.two";

}
