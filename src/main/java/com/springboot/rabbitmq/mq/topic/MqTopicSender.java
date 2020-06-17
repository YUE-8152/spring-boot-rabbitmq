package com.springboot.rabbitmq.mq.topic;

import com.springboot.rabbitmq.common.constant.RabbitMqConstant;
import com.springboot.rabbitmq.model.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqTopicSender {
    private static final Logger logger = LoggerFactory.getLogger(MqTopicSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void topicSender(SysUser user) {
        logger.info("--------------topic类型消息生产者");
        System.out.println("--------------发送消息为" + user.toString());
        rabbitTemplate.convertAndSend(RabbitMqConstant.TOPIC_EXCHANGE,RabbitMqConstant.TOPIC_ONE_QUEUE,user.toString());
        rabbitTemplate.convertAndSend(RabbitMqConstant.TOPIC_EXCHANGE,RabbitMqConstant.TOPIC_TWO_QUEUE,user.toString());
    }
}
