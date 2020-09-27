package com.yrj.spring_boot_demo.service.impl;

import com.yrj.spring_boot_demo.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @类描述@：
 * @Author: 余仁杰
 * @Date: 2020/9/27 22:01
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public void test001(String str) {
        System.out.println(str);
    }
}
