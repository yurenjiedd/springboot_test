package com.yrj.spring_boot_demo.test;

import com.alibaba.fastjson.JSONArray;
import com.yrj.spring_boot_demo.SpringBootDemoApplication;
import com.yrj.spring_boot_demo.config.bean.TempFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @类描述@：
 * @Author: 余仁杰
 * @Date: 2020/9/4 0:13
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringBootDemoApplication.class);
        TestBean testBean = (TestBean) applicationContext.getBean("tempFactoryBean");
        TestBean testBean1 = (TestBean) applicationContext.getBean("tempFactoryBean");
        testBean.test001();
        testBean1.test001();
        System.err.println(testBean.hashCode()+" ----------- "+testBean1.hashCode());

        TempFactoryBean tempFactoryBean = (TempFactoryBean) applicationContext.getBean("&tempFactoryBean");
        System.out.println("TempFactoryBean class:"+tempFactoryBean.getClass());

        Object object = tempFactoryBean.getObject();
        System.err.println("object:"+ JSONArray.toJSONString(object));

    }
}
