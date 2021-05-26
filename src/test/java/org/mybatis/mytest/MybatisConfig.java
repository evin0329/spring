package org.mybatis.mytest;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@Order(Integer.MIN_VALUE)
public class MybatisConfig {

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&serverTimezone=GMT");
    driverManagerDataSource.setUsername("root");
    driverManagerDataSource.setPassword("123456");

    return driverManagerDataSource;
  }


  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean ss = new SqlSessionFactoryBean();
    ss.setDataSource(dataSource());
//    ss.setMapperLocations(new ClassPathResource("org/mybatis/spring/sample/mapper/UserMapper.xml"));
    ss.setMapperLocations(new ClassPathResource("org/mybatis/mytest/UserMapper.xml"));
    SqlSessionFactory sqlSessionFactory = ss.getObject();
    return sqlSessionFactory;
  }

//  @Bean
  public UserMapper userMapper() throws Exception {
    // when using javaconfig a template requires less lines than a MapperFactoryBean
    SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
    return sqlSessionTemplate.getMapper(UserMapper.class);
  }

//    @Bean
  public MapperFactoryBean userMapperMapperFactoryBean() throws Exception {
      MapperFactoryBean<UserMapper> mapperFactoryBean = new MapperFactoryBean<>();
      mapperFactoryBean.setMapperInterface(UserMapper.class);
      mapperFactoryBean.setAddToConfig(true);
      mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory());
      mapperFactoryBean.setSqlSessionTemplate(new SqlSessionTemplate(sqlSessionFactory()));

      return mapperFactoryBean;
  }

  @Bean
  public ApplicationListenerDemo applicationListenerDemo(){
    return new ApplicationListenerDemo();
  }

}