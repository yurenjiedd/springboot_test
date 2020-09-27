package com.yrj.spring_boot_demo.initialize;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @类描述@：
 * @Author: 余仁杰
 * @Date: 2020/7/18 15:25
 */
@Component
public class InitializeService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    public String getInitializeValue(String key){
        //getEnvironment:返回环境配置（Key：value）
        return applicationContext.getEnvironment().getProperty(key);
    }
}
