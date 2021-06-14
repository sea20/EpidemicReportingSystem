package com.mapper;
import com.bean.Leave;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
@Repository
public interface LeaveServiceMapper {
    //提交报备信息
    Integer submit(Leave leave);
    List<Object> findByState(@Param("state")Integer state, @Param("id")Integer id);

}
