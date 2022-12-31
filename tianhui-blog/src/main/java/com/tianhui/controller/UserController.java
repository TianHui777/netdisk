package com.tianhui.controller;

import com.tianhui.entity.ResponseResult;
import com.tianhui.entity.User;
import com.tianhui.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(value = "用户信息管理", tags = "用户信息管理")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("获取用户信息接口")
    @GetMapping("/userInfo")
    public ResponseResult userInfo() {

        return userService.userInfo();

    }

    @ApiOperation("修改用户信息接口")
    @PutMapping("/userInfo")
    public ResponseResult updateUserInfo(
            @ApiParam(name = "user", value = "请求体为json类型数据，填写需要修改的信息", required = true)
            @RequestBody User user) {
        return userService.updateUserInfo(user);
    }

    @ApiOperation("注册接口")
    @PostMapping("/register")
    public ResponseResult register(
            @ApiParam(name = "user", value = "json类型数据", required = true)
            @RequestBody User user) {

        return userService.register(user);

    }
}
