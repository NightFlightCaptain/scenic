package com.hust.software.scenic.controller;

import com.hust.software.scenic.mgb.model.User;
import com.hust.software.scenic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 小栗旬
 * @Date: 2019/10/22 22:40
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getUser")
    public User getUser(){
        return userService.getUser(1);
    }

}
