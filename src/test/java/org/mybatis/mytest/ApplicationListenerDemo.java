package org.mybatis.mytest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

public class ApplicationListenerDemo implements org.springframework.context.ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  UserMapper userMapper;


  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    User user = userMapper.getUser("1");
    System.out.println(user);
  }
}
