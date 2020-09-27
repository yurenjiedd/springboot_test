package com.yrj.spring_boot_demo.model.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @类描述@：
 * @Author: 余仁杰
 * @Date: 2020/5/3 21:06
 */
@Data
public class UserVo {
    @NotBlank(message = "name不能为null")
    @Length(max = 10,min = 1,message = "姓名长度1 ~ 10之间！")
    private String name;
    @NotNull(message = "age不能为null")
    @Max(value = 200,message = "age不能超过200")
    @Max(value = 0,message = "age不能低于0")
    private Integer age;
    @NotBlank(message = "sex不能为null")
    private String sex;
    @NotEmpty(message = "电话不能为空")
    private List<String> phone;

    public UserVo(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
