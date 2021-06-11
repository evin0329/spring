package org.mybatis.mytest;

import org.mybatis.mytest.mapper.SsoUser;
import org.mybatis.mytest.mapper.SsoUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationListenerDemo implements org.springframework.context.ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  SsoUserMapper userMapper;


  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    SsoUser user = userMapper.getById(1);
    System.out.println(user);
  }
}
