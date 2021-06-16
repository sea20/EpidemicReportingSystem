package com.service;

import com.bean.User;
import com.bean.information.LoginInfor;
import com.bean.result.Result;

import javax.servlet.http.HttpSession;
import java.sql.Date;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
public interface UserService {
    Result login(LoginInfor loginInfor, HttpSession session);

    Result getUsers(Integer type, Date date);

    Result register(User user);
}
