package com.service;

import com.bean.Leave;
import com.bean.User;
import com.bean.result.Result;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
public interface LeaveService {
    Result submit(Leave leave);
    Result findByState(Integer state,Integer id);

    Result deleteById(Integer id,User user);


    Result getUsersByType(Integer type);

    Result judgeLeave(Integer type, Integer id);

    Result getLeaveById(Integer id);
}
