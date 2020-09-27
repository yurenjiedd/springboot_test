package com.yrj.spring_boot_demo;

import com.yrj.spring_boot_demo.web.DemoController;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;

//junit5只需要添加 @SpringBootTest  注解
@SpringBootTest
public class SpringBootDemoApplicationTests {

    @Test
    public void contextLoads() throws Exception {

        System.out.println("1111111111111");

    }

}
