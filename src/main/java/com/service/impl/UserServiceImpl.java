package com.service.impl;

import com.bean.User;
import com.bean.information.LoginInfor;
import com.bean.result.Result;
import com.mapper.UserServiceMapper;
import com.service.UserService;
import com.utils.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserServiceMapper userServiceMapper;

    @Override
    public Result login(LoginInfor loginInfor, HttpSession session) {
        User user = userServiceMapper.login(loginInfor);
        if (user == null){
            return R.Error("账号或密码错误");
        }else {
            user.setPassword("********");
            //把登录信息保存到sessio中
            session.setAttribute("user",user);
            System.out.println(user);
            System.out.println(session.getAttribute("user"));
            return R.Ok();
        }
    }

    //注册
    @Override
    public Result regist(User user, String judge) {
        if("admine".equals(judge)){
            //管理员注册
            user.setType(1);
        }else {
            //普通用户注册
            user.setType(2);
        }
        int res = 0;
        try {
            res = userServiceMapper.regist(user);
        } catch (Exception e) {
            System.out.println(e);
            return R.Error();
        }
        if(res == 1){
            return R.Ok();
        }else {
            return R.Error();
        }
    }
}
