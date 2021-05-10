package com.service;

import com.bean.Test;
import com.bean.result.Result;
import com.utils.result.R;

/**
 * @Auther: Maple
 * @Date: 2021/5/10
 */
public interface TestService {
    Result getUserById(Integer id);
}
