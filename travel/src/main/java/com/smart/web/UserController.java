package com.smart.web;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public User login(@RequestParam(value = "userAccount") String userAccount, @RequestParam(value = "password") String password) {
        User user = userService.login(userAccount, password);
        return user;
    }
    @RequestMapping("/loginByWx")
    public User loginByWx(@RequestParam(value = "wxCode") String wxCode)  {
        User user = userService.loginByWx(wxCode);
        return user;
    }
    @RequestMapping("/changeInfo")
    public Map<String, Object> changeInfo(User user){
       String msg= userService.changeInfo(user);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg",msg);
        return map;
    }
    @RequestMapping("/register")
    public Map<String, Object> register(User user){
//        System.out.println(user);
        String msg= userService.register(user);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg",msg);
       return map;
    }
    @RequestMapping("/bindWx")
    public Map<String, Object> bindWx(@RequestParam(value = "userAccount") String userAccount, @RequestParam(value = "password") String password,@RequestParam(value = "wxCode") String wxCode){
            String msg=userService.bindWx(userAccount,password,wxCode);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg",msg);
        return map;
    }
    @RequestMapping("/test")
    public Map<String, Object>  test(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg","连接成功");
        return map;
    }
}

