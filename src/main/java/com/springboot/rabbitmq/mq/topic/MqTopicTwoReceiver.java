package com.springboot.rabbitmq.mq.topic;

import com.springboot.rabbitmq.common.constant.RabbitMqConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MqTopicTwoReceiver {
    private static final Logger logger = LoggerFactory.getLogger(MqTopicTwoReceiver.class);

    @RabbitListener(queues = RabbitMqConstant.TOPIC_TWO_QUEUE)
    public void topicTwoReceiver(String user) {
        logger.info("------------topic two 消费者");
        System.out.println("----------------接受的消息：" + user);
    }
}
