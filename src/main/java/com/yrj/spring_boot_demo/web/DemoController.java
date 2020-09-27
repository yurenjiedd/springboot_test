package com.yrj.spring_boot_demo.web;

import com.yrj.spring_boot_demo.initialize.InitializeService;
import com.yrj.spring_boot_demo.model.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @类描述@：
 * @Author: 余仁杰
 * @Date: 2020/5/3 11:45
 */
//@Slf4j
@Controller
public class DemoController {
    @Autowired
    private InitializeService initializeService;

    @RequestMapping("/test1")
    public String test1(){
        return "Hello.html";
    }

//    @RequestMapping("/test2")
    @ResponseBody
    @PostMapping("/test2")
    public String test2(@RequestParam String name,@RequestParam String password){
        System.out.println(name+" - "+password);
        return name+" - "+password;
    }

    @RequestMapping("/test3")
    @ResponseBody
    public String test3(@Validated UserVo user, BindingResult result){
        /**
         * @Validated 表示开启校验，后面必须跟着一个参数BindingResult，表示校验失败的错误信息
         * 如果BindingResult的hasErrors()为true，表示校验不通过
         */
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                FieldError fieldError= (FieldError) error;
                //字段名
                String field = fieldError.getField();
                //错误提示信息
                String msg = fieldError.getDefaultMessage();
                System.out.println(field+":"+msg);
            }
        }
        return "呵呵";
    }

    @ResponseBody
    @GetMapping("/test4")
    public String test4(@RequestParam String key){
        return initializeService.getInitializeValue(key);
    }
}
