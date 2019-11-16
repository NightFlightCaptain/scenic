package com.smart.service;

import com.smart.dao.UserMapper;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public String register(User user){
        if(user.getUserName()==null||user.getPassword()==null||user.getUserAccount()==null)
            return "failure";
       userMapper.insert(user);
       return "success";
    }
    public User login(String userAccount,String password){
        User user=userMapper.selectByAccount(userAccount);
        if(user!=null&&user.getPassword().equals(password))
            return user;
        else
            return null;

    }
    public User loginByWx(String wxCode){
        User user=userMapper.selectByWxCode(wxCode);
       return user;
    }
    public String changeInfo(User user){
        int i=userMapper.updateByPrimaryKey(user);
        if(1==i)
            return "success";
        else
            return "failure";
    }

    public String bindWx(String userAccount,String password,String wxCode){
        User user=login(userAccount,password);
        if(user==null)
            return "failure";
        else {
            user.setWxCode(wxCode);
            changeInfo(user);
            return "success";
        }
    }
}
