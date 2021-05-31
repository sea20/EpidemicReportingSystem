package com.controller;

import com.bean.result.Result;
import com.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Controller
@Api(tags = "测试")
@RequestMapping("/")
public class TestController {

    @Autowired
    TestService testService;


    @ResponseBody
    @ApiOperation("查找用户")
    @GetMapping("/test/getUser/{id}")
    @ApiImplicitParam(name = "id",value = "用户id",paramType = "path",dataType = "int")
    public Result getUser(@PathVariable Integer id){

        return testService.getUserById(id);

    }


    @RequestMapping("/")
    public String index(){
        return "indsa11dasex";
    }

    @RequestMapping("/sadasdsd")
    public String index11(){
        return "inde1x";
    }
    @RequestMapping("/sada213sdsd")
    public String index11231(){
        return "inde1x";
    }
}
