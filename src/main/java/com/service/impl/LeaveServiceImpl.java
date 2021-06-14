package com.service.impl;
import com.bean.Leave;
import com.bean.result.Result;
import com.mapper.LeaveServiceMapper;
import com.service.LeaveService;
import com.utils.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    LeaveServiceMapper leaveServiceMapper;
    @Override
    public Result submit(Leave leave){
        Integer submit = null;
        try {
            submit = leaveServiceMapper.submit(leave);
            System.out.println(1122334);
        }
        catch (Exception e){
            System.out.println(987654321);
            System.out.println(e.toString());
            return R.Error("提交失败！!");
        }
        if(submit==null||submit==0){
            return R.Error();
        }else{
            System.out.println(3344554);
            return R.Ok();
        }
    }
    @Override
    public Result findByState(Integer state,Integer id){
        List<Object> byState = null;
        try{
            byState = leaveServiceMapper.findByState(state, id);
        }catch (Exception e){
            System.out.println(e);
            return R.Error("查询错误");
        }
        if(byState==null){
            return R.Error("没查到~~~");
        }
        Result re = new Result();
        re.setData((HashMap) byState.get(0));
        re.setState(200);
        return re;

    }



}
