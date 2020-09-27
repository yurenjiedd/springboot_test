package com.yrj.spring_boot_demo.web;

import com.yrj.spring_boot_demo.model.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @类描述@：
 * @Author: 余仁杰
 * @Date: 2020/5/3 22:36
 */
@Controller
@Slf4j
public class ThymeleafController {

    @RequestMapping("/thymeleafTest1")
    public String test1(Model model){
        model.addAttribute("name","YRJ");
        model.addAttribute("msg","这是一个Thymeleaf测试");
        model.addAttribute("age","女");
        return "ThymeleafTest1";
    }

    @GetMapping("/thymeleafTest2")
    public String test2(Model model){
        UserVo user1=new UserVo("张三",18,"男");
        UserVo user2=new UserVo("李四",19,"男");
        UserVo user3=new UserVo("美美",20,"女");

        List<UserVo> list=new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        model.addAttribute("userList",list);
        return "ThymeleafTest2";
    }

    @GetMapping("/thymeleafTest3")
    public String test3(Model model){
        UserVo user1=new UserVo("张三",18,"男");
        UserVo user2=new UserVo("李四",19,"男");
        UserVo user3=new UserVo("美美",20,"女");

        Map<String,Object> map=new HashMap<>();
        map.put("user1",user1);
        map.put("user2",user2);
        map.put("user3",user3);
        model.addAttribute("map",map);
        return "ThymeleafTest3";
    }

    @GetMapping("/errorTest")
    @ResponseBody
    public String errorTest(){
        List<String> list=new ArrayList<>();
        log.error("进入error");
        return list.get(0);
    }

    /*@ExceptionHandler(Exception.class)
    public String test4(Exception e){
        //回默认使用模板，而不是静态页，故error1.html要放置在templates目录中
        log.info("错误信息：{}",e.toString());
        return "error1";
    }*/
}
