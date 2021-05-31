package com.mapper;

import com.bean.User;
import com.bean.information.LoginInfor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
@Repository
public interface UserServiceMapper {
    //登录
    User login(LoginInfor loginInfor);
    //注册
    int regist(User user);
}
