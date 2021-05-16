package com.controller;

import com.bean.User;
import com.bean.information.LoginInfor;
import com.bean.result.Result;
import com.service.UserService;
import com.utils.result.R;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Date;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
@Controller
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("登录")
    @ResponseBody
    @PostMapping("/login")
    @ApiImplicitParam(name = "loginInfor" ,value = "用户登录信息", paramType = "body",dataType = "LoginInfor")
    public Result login(@RequestBody LoginInfor loginInfor, HttpSession session){
        return userService.login(loginInfor,session);
    }


    //未完成
    @ApiOperation("注册")
    @ResponseBody
    @PostMapping("/regist/{judge}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user" ,value = "用户注册信息", paramType = "body",dataType = "User"),
            @ApiImplicitParam(name = "judge" ,value = "判断是否为管理员用户,如果judge传入的参数为admine则为注册管理员", paramType = "path",dataType = "String")
    })
    public Result regist(@RequestBody User user,@PathVariable String judge){
        System.out.println(user);
        System.out.println(judge);
        return R.Ok();
    }


    //未完成
    @ApiOperation("查看注册用户哪些人没提交/提交了每日健康信息")
    @ResponseBody
    @PostMapping("/getUsers/{type}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type" ,value = "查询类型 1：提交了的 2：未提交的 3:所有的", paramType = "body",dataType = "Information"),
            @ApiImplicitParam(name = "date" ,value = "要查询哪天的 年月日", paramType = "body")
    })
    public Result getUsers(@PathVariable Integer type, @RequestBody Date date){
        System.out.println(type);
        System.out.println(date);
        return R.Ok().add("data","需要返回的数据");
    }


}
