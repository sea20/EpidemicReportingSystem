package com.bean;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Maple
 * @Date: 2021/5/10
 */
@ApiModel(description = "测试")
public class Test {
    @ApiModelProperty(value = "名字")
    String name;
    @ApiModelProperty(value = "年龄")
    Integer age;
    @ApiModelProperty(value = "用户id")
    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
