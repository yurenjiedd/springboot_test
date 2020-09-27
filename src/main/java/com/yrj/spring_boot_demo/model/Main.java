package com.yrj.spring_boot_demo.model;

import com.yrj.spring_boot_demo.SpringBootDemoApplication;
import com.yrj.spring_boot_demo.service.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @类描述@：
 * @Author: 余仁杰
 * @Date: 2020/8/1 20:24
 */
public final class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootDemoApplication.class, args);
        TestService bean = (TestService)run.getBean("testServiceImpl");
        bean.test001("-------------");
    }
}
