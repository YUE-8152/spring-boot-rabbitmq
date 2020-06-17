package com.springboot.rabbitmq.config;

import com.springboot.rabbitmq.common.constant.RabbitMqConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    /******************************************* 配置队列 ****************************************************/
    @Bean
    public Queue defaultQueue() {
        return new Queue(RabbitMqConstant.DEFAULT_QUEUE, true);
    }

    @Bean
    public Queue msgQueue() {
        return new Queue(RabbitMqConstant.MSG_QUEUE, true);
    }

    @Bean
    public Queue emailQueue() {
        return new Queue(RabbitMqConstant.EMAIL_QUEUE, true);
    }

    @Bean
    public Queue fanoutQueue() {
        return new Queue(RabbitMqConstant.FANOUT_QUEUE, true);
    }

    @Bean
    public Queue topicOneQueue() {
        return new Queue(RabbitMqConstant.TOPIC_ONE_QUEUE, true);
    }

    @Bean
    public Queue topicTwoQueue() {
        return new Queue(RabbitMqConstant.TOPIC_TWO_QUEUE, true);
    }


    /******************************************* 配置交换机 ****************************************************/

    /**
     * 如果路由键匹配，则直接投递到对应的队列
     *
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(RabbitMqConstant.DIRECT_EXCHANGE);
    }

    /**
     * 处理路由键，按模式匹配，向符合规则的队列投递消息
     *
     * @return
     */
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(RabbitMqConstant.TOPIC_EXCHANGE);
    }

    /**
     * 不处理路由键，向所有与之绑定的队列投递消息
     *
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitMqConstant.FANOUT_EXCHANGE);
    }


    /**********************************************  交换机与队列,路由绑定  **********************************************/
    @Bean
    Binding defaultBindingDirect() {
        return BindingBuilder.bind(defaultQueue()).to(directExchange()).with(RabbitMqConstant.DEFAULT_ROUTING_KEY);
    }

    @Bean
    Binding msgBindingDirect() {
        return BindingBuilder.bind(msgQueue()).to(directExchange()).with(RabbitMqConstant.MSG_ROUTING_KEY);
    }

    @Bean
    Binding emailBindingDirect() {
        return BindingBuilder.bind(emailQueue()).to(directExchange()).with(RabbitMqConstant.EMAIL_ROUTING_KEY);
    }

    /**
     * 将队列msg_queue,email_queue与fanout_exchange绑定
     *
     * @return
     */
    @Bean
    Binding msgFanoutExchange() {
        return BindingBuilder.bind(msgQueue()).to(fanoutExchange());
    }

    @Bean
    Binding emailFanoutExchange() {
        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
    }


    /**
     * 将队列topic.one,topic.two与topic_exchange绑定，binding_key为topic.message,模糊匹配
     *
     * @return
     */
    @Bean
    Binding topicAllExchange() {
        return BindingBuilder.bind(topicOneQueue()).to(topicExchange()).with(RabbitMqConstant.TOPIC_ROUTING_ALL_KEY);
    }

    @Bean
    Binding topicOneExchange() {
        return BindingBuilder.bind(topicTwoQueue()).to(topicExchange()).with(RabbitMqConstant.TOPIC_ROUTING_ONE_KEY);
    }

}
