package com.service;

import com.bean.User;
import com.bean.information.LoginInfor;
import com.bean.result.Result;

import javax.servlet.http.HttpSession;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
public interface UserService {
    //登录
    Result login(LoginInfor loginInfor, HttpSession session);
    //注册
    Result regist(User user, String judge);
}
