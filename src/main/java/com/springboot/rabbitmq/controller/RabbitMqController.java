package com.springboot.rabbitmq.controller;

import com.springboot.rabbitmq.model.SysUser;
import com.springboot.rabbitmq.mq.direct.MqDirectSender;
import com.springboot.rabbitmq.mq.fanout.MqFanoutSender;
import com.springboot.rabbitmq.mq.topic.MqTopicSender;
import com.springboot.rabbitmq.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendMsg")
public class RabbitMqController {

    @Autowired
    private SysUserService userService;

    @Autowired
    private MqDirectSender mqDirectSender;

    @Autowired
    private MqFanoutSender mqFanoutSender;

    @Autowired
    private MqTopicSender mqTopicSender;

    @PostMapping("/user")
    public void sendUserInfo(){
        SysUser sysUser = userService.findAll().get(0);
        mqDirectSender.sendMsg(sysUser);
    }

    @PostMapping("/fanout")
    public void fanoutUserInfo(){
        SysUser sysUser = userService.findAll().get(0);
        mqFanoutSender.sendMsg(sysUser);
    }

    @PostMapping("/topic")
    public void topicUserInfo(){
        SysUser sysUser = userService.findAll().get(0);
        mqTopicSender.topicSender(sysUser);
    }
}
