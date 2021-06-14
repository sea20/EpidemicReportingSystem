package com.service;

import com.bean.Leave;
import com.bean.result.Result;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
public interface LeaveService {
    Result submit(Leave leave);
    Result findByState(Integer state,Integer id);
}
