package com.service.impl;

import com.bean.Test;
import com.bean.result.Result;
import com.mapper.TestMapper;
import com.service.TestService;
import com.utils.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: Maple
 * @Date: 2021/5/10
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    TestMapper testMapper;
    @Override
    public Result getUserById(Integer id) {
        try {
            Test user = testMapper.getUserById(id);
            Test user2 = testMapper.getUserById(id);
            Integer integer = testMapper.updateById(2, 11);
            getUserByIdIn(id);
            boolean flag = true;
            if(user != null){
                return R.Ok().add("data",user);
            }else {
                return R.Empty();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.Error("查询用户出错");
        }
    }
    public Result getUserByIdIn(Integer id)  {
        Test user = testMapper.getUserById(1);
        return null;
    }
}
