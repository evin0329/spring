package org.mybatis.mytest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.locks.LockSupport;

//@MapperScan
public class SpringMybatisTest {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.mybatis.mytest");
    context.start();

    LockSupport.park();
  }


}
