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
    Result login(LoginInfor loginInfor, HttpSession session);
}
