package com.controller;
import com.bean.Leave;
import com.bean.User;
import com.bean.result.Result;
import com.service.LeaveService;
import com.utils.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
/**
 * @Auther: Maple
 * @Date: 2021/5/16
 */
@Controller
@RequestMapping("/leave")
@Api(tags = "外出报备")
public class LeaveController {
    @Autowired
    LeaveService leaveService;

    //已完成
    @ApiOperation("提交外出申请")
    @PostMapping("/submit")
    @ApiImplicitParam(name = "leave",value = "外出报备信息",dataType = "Leave" ,paramType = "body")
    @ResponseBody
    public Result submit(@RequestBody Leave leave, HttpSession session){
        System.out.println(leave);
        System.out.println(123);
        //通过session获得登录用户的信息
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        return leaveService.submit(leave);
    }

    //已完成，但是一次只能查到一行数据
    @ApiOperation("查看自己提交的外出申请(根据不同状态的)")
    @PostMapping("/getByState/{state}")
    @ApiImplicitParam(name = "state",value = "状态1：未审核 2：已通过 3：已拒绝",dataType = "int" ,paramType = "path")
    @ResponseBody
    public Result getByState(@PathVariable Integer state, HttpSession session){
        System.out.println(state);
        //通过session获得登录用户的信息
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        return leaveService.findByState(state,user.getId());
    }


    //未完成
    @ApiOperation("删除报备信息通过id")
    @PostMapping("/deleteById/{id}")
    @ApiImplicitParam(name = "id",value = "报备信息的id",dataType = "int" ,paramType = "path")
    @ResponseBody
    public Result deleteById(@PathVariable Integer id, HttpSession session){
        System.out.println(id);
        //通过session获得登录用户的信息
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        return R.Ok();
    }

    //未完成
    @ApiOperation("查看谁提交了外出报备信息按照id降序")
    @PostMapping("/getByType/{type}")
    @ApiImplicitParam(name = "type",value = "查看的类型1：未审批 2：拒绝 3：同意",dataType = "int" ,paramType = "path")
    @ResponseBody
    public Result deleteById(@PathVariable Integer type){
        System.out.println(type);
        return R.Ok();
    }


    //未完成
    @ApiOperation("审批外出报备信息")
    @PostMapping("/judgeLeave/{type}/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "审批的类型1：同意 2：拒绝",dataType = "int" ,paramType = "path"),
            @ApiImplicitParam(name = "id",value = "报备信息id",dataType = "int" ,paramType = "path")
    })
    @ResponseBody
    public Result judgeLeave(@PathVariable Integer type,@PathVariable Integer id){
        System.out.println(type);
        System.out.println(id);
        return R.Ok();
    }


    //未完成
    @ApiOperation("查看详细的外出报备信息")
    @PostMapping("/getLeaveById/{id}")
    @ApiImplicitParam(name = "id",value = "报备信息id",dataType = "int" ,paramType = "path")
    @ResponseBody
    public Result getLeaveById(@PathVariable Integer id){
        System.out.println(id);
        return R.Ok();
    }



}
