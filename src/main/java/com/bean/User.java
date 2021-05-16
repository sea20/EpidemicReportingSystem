package com.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
@ApiModel(description = "用户信息",value = "User")
public class User {
    @ApiModelProperty(value = "主键id,会自动生成，不用管他",hidden = true)
    Integer id;
    @ApiModelProperty(value = "用户名(登录名)",example = "xusea")
    String username;
    @ApiModelProperty(value = "密码",example = "a123456a")
    String password;
    @ApiModelProperty(value = "真实姓名",example = "安小然")
    String name;
    @ApiModelProperty(value = "性别 男/女", example = "男")
    String sex;
    @ApiModelProperty(value = "账号类型 1管理员 2 普通用户",hidden = true)
    Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", type=" + type +
                '}';
    }
}

