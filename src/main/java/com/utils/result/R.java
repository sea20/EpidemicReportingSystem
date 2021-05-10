package com.utils.result;

import com.bean.result.Result;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
public class R {

    public static Result Ok(){
        return new Result(200);
    }

    public static Result Error(String message){
        Result result = new Result(message);
        result.setState(400);
        return result;
    }

    public static Result Error(){
        Result result = new Result();
        result.setState(400);
        return result;
    }

    public static Result NotLogin(){
        Result result = new Result(401);
        result.setMessage("请登录");
        return result;
    }

    public static Result Exception(){
        Result result = new Result(402);
        result.setMessage("异常情况");
        return result;
    }

    public static Result Empty(){
        Result result = new Result(403);
        result.setMessage("空");
        return result;
    }
}
