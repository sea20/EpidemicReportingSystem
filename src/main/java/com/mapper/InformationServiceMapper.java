package com.mapper;
import com.bean.Information;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.sql.Date;

/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
@Repository
public interface InformationServiceMapper {
    //是否提交过
    Integer ifSubmit(@Param("uId") Integer uId,@Param("date") Date date);
    //提交
    Integer submit(Information information);
}
