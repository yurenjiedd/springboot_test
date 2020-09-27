package com.yrj.spring_boot_demo.initialize;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * 在SpringBoot初始化是给定参数
 * @类描述@：
 * @Author: 余仁杰
 * @Date: 2020/7/18 15:14
 */
//Order值越小，越先执行
@Order(1)
public class FastInitialize implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        Map<String,Object> map=new HashMap<>();
        map.put("key001","test");
        MapPropertySource mapPropertySource=new MapPropertySource("fastInitialize",map);
        environment.getPropertySources().addFirst(mapPropertySource);
        System.out.println("FastInitialize run ....");
    }
}

