package com.hust.software.scenic.controller;

import com.hust.software.scenic.common.CommonResult;
import com.hust.software.scenic.mgb.model.User;
import com.hust.software.scenic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 小栗旬
 * @Date: 2019/10/22 22:40
 */
@RestController()
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("user")
    public User addUser(User user){

        userService.addUser(user);
        return user;
    }

    @GetMapping("login")
    public CommonResult getUser(@RequestParam("account")String account,@RequestParam("password")String password){
        User user = userService.getUser(account,password);
        if (user == null){
            return CommonResult.failed();
        }
        return CommonResult.success(user);
    }

}
