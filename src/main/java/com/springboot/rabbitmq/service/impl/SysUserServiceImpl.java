package com.springboot.rabbitmq.service.impl;

import com.springboot.rabbitmq.dao.SysUserMapper;
import com.springboot.rabbitmq.model.SysUser;
import com.springboot.rabbitmq.service.SysUserService;
import com.springboot.rabbitmq.common.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @Author: YUEXIN
 * @Date: 2020-06-16 16:06:25
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

}
