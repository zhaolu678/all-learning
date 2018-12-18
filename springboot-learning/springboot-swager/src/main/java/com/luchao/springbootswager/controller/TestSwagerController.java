package com.luchao.springbootswager.controller;

import com.luchao.springbootswager.pojo.User;
import io.swagger.annotations.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api("testController API TEST")
public class TestSwagerController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String toindex() {
        return "OK";
    }

    @RequestMapping(value = "getuserstats/{usertoken}",method = RequestMethod.GET)
    @ApiOperation(value = "根据usertoken查询用户待办数", notes = "查某个用户的待办数")
    @ApiImplicitParam(name = "usertoken", value = "用户usertoken", paramType = "path", required = true, dataType = "String")
        public String getuserstats(Model model,@PathVariable String usertoken){
        System.out.println("============="+usertoken);
        return usertoken;
    }

    @ApiOperation("获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="username",dataType="String",required=true,value="用户姓名"),
            @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户密码"),
            @ApiImplicitParam(paramType="query",name="age",dataType="String",required=true,value="年龄",defaultValue="10")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value="/getUser",method=RequestMethod.GET)
    public User getStudent(String username,String password,Integer age) {
        User us= new User();
        us.setUserName(username);
        us.setPassword(password);
        us.setAge(age);
        return us;
    }

}
