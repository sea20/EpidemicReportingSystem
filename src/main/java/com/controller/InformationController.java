package com.controller;
import com.bean.Information;
import com.bean.User;
import com.bean.result.Result;
import com.service.InformationService;
import com.utils.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.sql.Date;
/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
@Controller
@RequestMapping("/information")
@Api(tags = "健康信息")
public class InformationController {
    @Autowired
    InformationService informationService;
    @ApiOperation("提交健康信息")
    @ResponseBody
    @PostMapping("/submit")
    @ApiImplicitParam(name = "information" ,value = "健康信息", paramType = "body",dataType = "Information")
    public Result submit(@RequestBody Information information, HttpSession session){
        //获取登录信息
        User user = (User) session.getAttribute("user");
        //设置用户id
        information.setuId(user.getId());
        return informationService.submit(information);
    }
    @ApiOperation("自己是否了提交健康信息")
    @ResponseBody
    @PostMapping("/ifSubmit")
    public Result ifSubmit(HttpSession session){
        //获取登录信息
        User user = (User) session.getAttribute("user");
        return informationService.ifSubmit(user.getId());
    }
    //半成品
    @ApiOperation("查看某人某天填报的具体信息")
    @ResponseBody
    @PostMapping("/getInformationById/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" ,value = "用户id", paramType = "path",dataType = "int"),
            @ApiImplicitParam(name = "date" ,value = "时间 年月日", paramType = "body",example = "2021-05-16")
    })
    public Result getInformationById(@PathVariable Integer id, @RequestBody Date date){
        System.out.println(id);
        System.out.println(date);
        return informationService.getInformationById(id,date);
    }
}
