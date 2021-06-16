package com.service.impl;
import com.bean.Leave;
import com.bean.User;
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
        if(byState==null || byState.size() == 0){
            return R.Error("没查到~~~");
        }
        return  R.Ok().add("data",byState);
    }

    @Override
    public Result deleteById(Integer id,User user) {
        int res = leaveServiceMapper.deleteById(id,user.getId());
        if(res == 0){
            return R.Error("删除失败");
        }else{
            return R.Ok("删除成功");
        }
    }

    @Override
    public Result getUsersByType(Integer type) {
        List<User> list =  leaveServiceMapper.getUsersByType(2);
        if (list == null || list.size() == 0){
            return R.Empty();
        }else {
            Result ok = R.Ok();
            for (User user : list) {
                List<Integer> id = leaveServiceMapper.getLeaveId(type,user.getId());
                ok.add(user.getName(),id);

            }
            return ok;
        }
    }

    @Override
    public Result judgeLeave(Integer type, Integer id) {
        if(type == 1){
            type = 2;
        }else if(type == 2){
            type = 3;
        }
        int res = leaveServiceMapper.judgeLeave(type,id);
        if(res == 0){
            return R.Error("操作失败");
        }else{
            String t = type == 2 ? "同意" : "拒绝";
            return R.Ok("已经将外出申请状态改为:"+t);
        }
    }

    @Override
    public Result getLeaveById(Integer id) {
        Leave leave = leaveServiceMapper.getLeaveById(id);
        if(leave == null){
            return R.Empty();
        }else{
            return R.Ok().add("data",leave);
        }
    }


}
