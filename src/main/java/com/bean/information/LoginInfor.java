package com.bean.information;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
@ApiModel(description = "登录信息",value = "LoginInfor")
public class LoginInfor {
    @ApiModelProperty(value = "用户名(登录名)",example = "xusea")
    String username;
    @ApiModelProperty(value = "密码",example = "a123456a")
    String password;

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

    @Override
    public String toString() {
        return "LoginInfor{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
