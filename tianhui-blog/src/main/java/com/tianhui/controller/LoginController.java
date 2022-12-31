package com.tianhui.controller;

import com.tianhui.entity.ResponseResult;
import com.tianhui.entity.User;
import com.tianhui.enums.AppHttpCodeEnum;
import com.tianhui.exception.SystemException;
import com.tianhui.service.BlogLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户登录", tags = "用户登录")
public class LoginController {
    @Autowired
    private BlogLoginService blogLoginService;

    @ApiOperation("用户登录接口")
    @PostMapping("/login")
    public ResponseResult login(
            @ApiParam(name = "user", value = "请求头为json类型数据，userName和password为必填项", required = true)
            @RequestBody User user) {

        // 如果没有携带用户名，则抛出异常
        if (!StringUtils.hasText(user.getUserName())) {
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }

        return blogLoginService.login(user);
    }

    @ApiOperation("登出接口，需要token")
    @PostMapping("/logout")
    public ResponseResult logout() {
        return blogLoginService.logout();
    }
}
