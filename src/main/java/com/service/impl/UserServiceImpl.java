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
}
