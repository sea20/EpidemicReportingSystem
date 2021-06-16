package com.service.impl;
import com.bean.Information;
import com.bean.User;
import com.bean.information.LoginInfor;
import com.bean.result.Result;
import com.mapper.InformationServiceMapper;
import com.mapper.LeaveServiceMapper;
import com.mapper.UserServiceMapper;
import com.service.InformationService;
import com.service.UserService;
import com.utils.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserServiceMapper userServiceMapper;
    @Autowired
    LeaveServiceMapper leaveServiceMapper;
    @Autowired
    InformationServiceMapper informationServiceMapper;
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
            return R.Ok("登录成功");
        }
    }

    @Override
    public Result getUsers(Integer type, Date date) {
        List<User> list = userServiceMapper.getUsers();
        List<User> result;
        Result ok = R.Ok();
        if(type == 1){
            //提交了的
            ok.add("描述","已经提交了今日的健康信息的用户");
            result = new ArrayList<>();
            for (User user : list) {
                Integer res = informationServiceMapper.ifSubmit(user.getId(), date);
                if(res != null && res > 0){
                    //已经提交
                    result.add(user);
                }
            }
            ok.add("用户",result);
        }else {
            //未提交的
            ok.add("描述","未提交今日的健康信息的用户");
            result = new ArrayList<>();
            for (User user : list) {
                Integer res = informationServiceMapper.ifSubmit(user.getId(), date);
                if(res == null || res == 0){
                    //未提交
                    result.add(user);
                }
            }
            ok.add("用户",result);
        }
        return ok;
    }

    @Override
    public Result register(User user) {
        try {
            Integer res = userServiceMapper.register(user);
            if (res == 1){
                return R.Ok("注册成功");
            }else{
                return R.Error();
            }
        } catch (Exception e) {
            return R.Error("注册失败，用户名可能已经存在");
        }
    }
}
