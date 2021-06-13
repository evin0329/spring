package org.mybatis.mytest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationListenerDemo implements org.springframework.context.ApplicationListener<ContextRefreshedEvent> {



  @Autowired
  UserService userService;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    userService.insert();
  }
}
