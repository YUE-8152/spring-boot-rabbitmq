package com.springboot.rabbitmq.mq.fanout;

import com.springboot.rabbitmq.common.constant.RabbitMqConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MqFanoutEmailReceiver {
    private static final Logger logger = LoggerFactory.getLogger(MqFanoutEmailReceiver.class);

    @RabbitListener(queues = RabbitMqConstant.EMAIL_QUEUE)
    public void fanoutEmailReceiver(String user) {
        logger.info("------------------Email订阅的消息");
        System.out.println("-------------"+user);
    }
}
