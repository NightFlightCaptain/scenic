package com.hust.software.scenic.service.impl;

import com.hust.software.scenic.common.MD5Util;
import com.hust.software.scenic.mgb.mapper.UserMapper;
import com.hust.software.scenic.mgb.model.User;
import com.hust.software.scenic.mgb.model.UserExample;
import com.hust.software.scenic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author: 小栗旬
 * @Date: 2019/10/22 22:42
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User addUser(User user) {
        user.setSolt(UUID.randomUUID().toString().substring(0,5));
        user.setPassword(MD5Util.MD5(user.getPassword()+user.getSolt()));
        userMapper.insertSelective(user);
        return user;
    }

    @Override
    public User getUser(String account, String password){
        User user = userMapper.getUserByAccount(account);
        if (user == null){
            return null;
        }

        if (!user.getPassword().equals(MD5Util.MD5(password+user.getSolt()))){
            return null;
        }
        return user;
    }


}
