package com.yrj.spring_boot_demo.web;

import com.yrj.spring_boot_demo.model.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @类描述@：
 * @Author: 余仁杰
 * @Date: 2020/5/3 20:56
 */
@Controller
public class FreemarkerController {

    @GetMapping("freemarkerTest1")
    public String test1(Map<String,Object> map){
        map.put("name","yrj");
        map.put("msg","这是一个测试例子");
        return "FreemarkerTest1";
    }

    @GetMapping("freemarkerTest2")
    public String test2(Map<String,Object> map){
        map.put("name","yrj");
        map.put("msg","这是一个测试例子");

        UserVo user1=new UserVo("张三",18,"男");
        UserVo user2=new UserVo("李四",19,"男");
        UserVo user3=new UserVo("美美",20,"女");

        List<UserVo> list=new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        map.put("userList",list);
        return "FreemarkerTest2";
    }

}
