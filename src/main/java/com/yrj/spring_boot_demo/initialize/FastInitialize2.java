package com.yrj.spring_boot_demo.initialize;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * 在SpringBoot初始化是给定参数
 * @类描述@：
 * @Author: 余仁杰
 * @Date: 2020/7/18 15:14
 */
@Order(2)
public class FastInitialize2 implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        Map<String,Object> map=new HashMap<>();
        map.put("key002","test2");
        MapPropertySource mapPropertySource=new MapPropertySource("fastInitialize",map);
        environment.getPropertySources().addFirst(mapPropertySource);
        System.out.println("FastInitialize2 run ....");
    }
}
