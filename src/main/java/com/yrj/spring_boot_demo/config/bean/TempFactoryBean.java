package com.yrj.spring_boot_demo.config.bean;

import com.yrj.spring_boot_demo.test.TestBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;


/**
 * @类描述@：
 * @Author: 余仁杰
 * @Date: 2020/9/4 0:11
 * <p>
 * FactoryBean:生成Bean工厂的bean
 * <p>
 * 当Spring扫描（加载）当前TempFactoryBean时，会加载2个对象到Spring容器
 * 一个是getObject（）方法返回的对象，另一个就是当前TempFactoryBean对象
 *
 * getObject（）方法返回的对象的加载名称为：当前类指定的名称
 * ----     当前getObject（）方法返回的对象的加载名称就是tempFactoryBean
 *
 * 而TempFactoryBean对象的加载名称是："&"+getObject（）方法返回的对象的加载
 * ----     当前的TempFactoryBean对象加载名称就是&tempFactoryBean
 */
@Component("tempFactoryBean")
public class TempFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {

        return new TestBean();
    }

    @Override
    public Class<?> getObjectType() {
        return TestBean.class;
    }

    /**
     * 是否是单例模式
     *
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
