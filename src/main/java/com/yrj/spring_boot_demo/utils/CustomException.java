package com.yrj.spring_boot_demo.utils;

/**
 * @类描述@：
 * @Author: 余仁杰
 * @Date: 2020/9/4 15:27
 */
public class CustomException extends RuntimeException {

    private String msg;

    public void setMsg(String msg) {
        if (msg == null || "".equals(msg)) {
            this.msg = null;
        } else {
            this.msg = msg;
        }
    }

    public CustomException(String msg) {
        super(msg);
        this.msg=msg;
    }

    public CustomException(Exception e) {
        super(e);
    }

    public CustomException(String msg,Exception e) {
        super(msg,e);
        this.msg=msg;
    }
}
