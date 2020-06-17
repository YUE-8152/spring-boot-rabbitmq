package com.springboot.rabbitmq.mq.direct;

import com.springboot.rabbitmq.common.constant.RabbitMqConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 */
@Component
public class MqDirectReceiver {
    private static final Logger logger = LoggerFactory.getLogger(MqDirectReceiver.class);

    @RabbitListener(queues = RabbitMqConstant.DEFAULT_QUEUE)  //消费指定队列中的消息
    private void userReceiver(String user){
        logger.info("------------消费者消费消息【{}】",user);
        System.out.println("----------------"+user);
    }
}
