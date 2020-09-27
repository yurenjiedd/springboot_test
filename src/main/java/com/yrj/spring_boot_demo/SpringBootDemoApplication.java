package com.yrj.spring_boot_demo;

import com.yrj.spring_boot_demo.initialize.FastInitialize;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
        exclude = {DataSourceAutoConfiguration.class}
        )
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);

//        SpringApplication springApplication=new SpringApplication(SpringBootDemoApplication.class);
//        springApplication.addInitializers(new FastInitialize());
//        springApplication.run(args);
    }

}
