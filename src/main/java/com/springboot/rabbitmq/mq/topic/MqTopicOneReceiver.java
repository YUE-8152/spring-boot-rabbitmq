package com.springboot.rabbitmq.mq.topic;

import com.springboot.rabbitmq.common.constant.RabbitMqConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MqTopicOneReceiver {
    private static final Logger logger = LoggerFactory.getLogger(MqTopicOneReceiver.class);

    @RabbitListener(queues = RabbitMqConstant.TOPIC_ONE_QUEUE)
    public void topicOneReceiver(String user) {
        logger.info("------------topic one 消费者");
        System.out.println("----------------接受的消息：" + user);
    }
}
