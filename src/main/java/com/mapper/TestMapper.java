package com.mapper;

import com.bean.Test;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Repository
public interface TestMapper {
    Test getUserById(@Param("id") Integer id);
    Integer updateById(@Param("id") Integer id,@Param("age") Integer age);
}
