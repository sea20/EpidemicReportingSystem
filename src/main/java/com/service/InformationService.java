package com.service;

import com.bean.Information;
import com.bean.result.Result;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
@Transactional
public interface InformationService {
    //提交健康信息
    Result submit(Information information);
    //判断自己是否提交过健康信息
    Result ifSubmit(Integer id);
    //查看某人某天填报的具体信息
    Result getInformationById(Integer id, Date date);
}
