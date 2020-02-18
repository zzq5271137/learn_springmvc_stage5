package com.mycomp.springmvc.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import java.util.Arrays;

@Getter
@Setter
public class User {

    @NotBlank(message = "用户名不允许为空")
    private String name;

    @Max(value = 120, message = "请输入合法年龄")
    private Integer age;

    private Integer gender; // 0: 男, 1: 女
    private String[] hobby;
    private Pet pet;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", hobby=" + Arrays.toString(hobby) +
                ", pet=" + pet +
                '}';
    }
}
