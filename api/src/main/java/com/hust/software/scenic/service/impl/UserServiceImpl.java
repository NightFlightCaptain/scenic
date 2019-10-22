package com.hust.software.scenic.service.impl;

import com.hust.software.scenic.mgb.mapper.UserMapper;
import com.hust.software.scenic.mgb.model.User;
import com.hust.software.scenic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 小栗旬
 * @Date: 2019/10/22 22:42
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int count() {
        return userMapper.countByExample(null);
    }

    @Override
    public User getUser(Integer id) {
        return userMapper.selectByPrimaryKey(1);
    }
}
