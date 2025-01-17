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

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan /* ("aa", annotationClass= Mapper.class) */
@EnableTransactionManagement
public class MybatisConfig {

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&serverTimezone=GMT");
    driverManagerDataSource.setUsername("root");
    driverManagerDataSource.setPassword("123456");
    return driverManagerDataSource;
  }

  @Bean
  public DataSourceTransactionManager dataSourceTransactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean ss = new SqlSessionFactoryBean();
    ss.setDataSource(dataSource());
    // ss.setMapperLocations(new ClassPathResource("org/mybatis/spring/sample/mapper/UserMapper.xml"));
    ss.setMapperLocations(new ClassPathResource("org/mybatis/mytest/mapper/UserMapper.xml"));
    SqlSessionFactory sqlSessionFactory = ss.getObject();
    return sqlSessionFactory;
  }

  // @Bean
  // public UserMapper userMapper() throws Exception {
  // // when using javaconfig a template requires less lines than a MapperFactoryBean
  // SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
  // return sqlSessionTemplate.getMapper(UserMapper.class);
  // }

  // @Bean
  // public MapperFactoryBean userMapperMapperFactoryBean() throws Exception {
  // MapperFactoryBean<UserMapper> mapperFactoryBean = new MapperFactoryBean<>();
  // mapperFactoryBean.setMapperInterface(UserMapper.class);
  // mapperFactoryBean.setAddToConfig(true);
  // mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory());
  // mapperFactoryBean.setSqlSessionTemplate(new SqlSessionTemplate(sqlSessionFactory()));
  //
  // return mapperFactoryBean;
  // }

  @Bean
  public ApplicationListenerDemo applicationListenerDemo() {
    return new ApplicationListenerDemo();
  }

}
