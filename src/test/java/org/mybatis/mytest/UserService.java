package org.mybatis.mytest;

import org.mybatis.mytest.mapper.User;
import org.mybatis.mytest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserService {

  @Autowired
  UserMapper userMapper;

  @Transactional
  public void insert(){
    User user = new User();
    user.setName("hepeng");
    user.setPhone("1234");
    user.setPhoneNumber("1234");
    user.setDeleted(0);

    userMapper.save(user);

    throw new RuntimeException("test");
  }
}
