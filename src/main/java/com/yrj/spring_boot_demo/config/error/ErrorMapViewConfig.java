package com.yrj.spring_boot_demo.config.error;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @类描述@：
 * @Author: 余仁杰
 * @Date: 2020/5/4 18:58
 */
@Configuration
public class ErrorMapViewConfig implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView view=new ModelAndView();
        if (e instanceof NullPointerException){
            view.setViewName("error1");
        }else if (e instanceof RuntimeException){
            view.setViewName("error1");
        }else if (e instanceof Exception){
            view.setViewName("error1");
        }else{
            view.setViewName("error1");
        }

        return view;
    }
}
