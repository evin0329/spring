/*
 * Copyright 2010-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
  public void insert() {
    User user = new User();
    user.setName("hepeng");
    user.setPhone("1234");
    user.setPhoneNumber("1234");
    user.setDeleted(0);

    userMapper.save(user);

    throw new RuntimeException("test");
  }
}
