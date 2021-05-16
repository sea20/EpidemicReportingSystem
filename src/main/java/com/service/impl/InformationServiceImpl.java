package com.service.impl;

import com.bean.Information;
import com.bean.Leave;
import com.bean.result.Result;
import com.mapper.InformationServiceMapper;
import com.service.InformationService;
import com.utils.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;


/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    InformationServiceMapper informationServiceMapper;
    @Override
    public Result submit(Information information) {
        //获取date，完善信息
        Date date = new Date(new java.util.Date().getTime());
        information.setCreateTime(date);
        Integer submit = null;

        try {
            //提交
            submit = informationServiceMapper.submit(information);
        } catch (Exception e) {
            return R.Error("提交失败");
        }

        if(submit == null || submit == 0){
            return R.Error("提交失败");
        }else {
            return R.Ok();
        }
    }

    @Override
    public Result ifSubmit(Integer id) {
        Date date = new Date(new java.util.Date().getTime());
        //是否提交
        Integer size = informationServiceMapper.ifSubmit(id, date);
        if(size == null || size == 0){
            return R.Ok();
        }else {
            return R.Error("已经提交过了");
        }
    }
}
