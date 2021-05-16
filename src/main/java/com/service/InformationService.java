package com.service;

import com.bean.Information;
import com.bean.Leave;
import com.bean.result.Result;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */

public interface InformationService {
    //提交健康信息
    Result submit(Information information);
    //判断自己是否提交过健康信息
    Result ifSubmit(Integer id);
}
