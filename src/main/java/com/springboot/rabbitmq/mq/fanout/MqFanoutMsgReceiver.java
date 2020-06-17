package com.springboot.rabbitmq.mq.fanout;

import com.springboot.rabbitmq.common.constant.RabbitMqConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MqFanoutMsgReceiver {

    private static final Logger logger = LoggerFactory.getLogger(MqFanoutMsgReceiver.class);

    @RabbitListener(queues = RabbitMqConstant.MSG_QUEUE)
    public void fanoutMsgReceiver(String user) {
        logger.info("------------------Msg订阅的消息");
        System.out.println("-------------" + user);
    }
}
