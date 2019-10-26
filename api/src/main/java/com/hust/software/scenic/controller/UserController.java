package com.hust.software.scenic.controller;

import com.hust.software.scenic.common.CommonResult;
import com.hust.software.scenic.mgb.model.User;
import com.hust.software.scenic.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 小栗旬
 * @Date: 2019/10/22 22:40
 */
@Api(tags = "UserController",description = "用户接口")
@RestController()
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("user")
    public CommonResult addUser(User user){
        return userService.addUser(user);
    }

    @GetMapping("user")
    public CommonResult getUser(@RequestParam("account")String account,@RequestParam("password")String password){
        return userService.getUser(account,password);
    }

}
