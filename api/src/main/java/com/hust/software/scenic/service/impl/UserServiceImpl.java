package com.hust.software.scenic.service.impl;

import com.hust.software.scenic.common.CommonResult;
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
    public CommonResult addUser(User user) {
        if (isUserExist(user.getAccount())) {
            return CommonResult.success("该账号已经存在");
        }
        user.setSolt(UUID.randomUUID().toString().substring(0, 5));
        user.setPassword(MD5Util.MD5(user.getPassword() + user.getSolt()));
        userMapper.insertSelective(user);
        return CommonResult.success("成功添加",user);
    }

    @Override
    public CommonResult getUser(String account, String password) {
        if (!isUserExist(account)){
            return CommonResult.success("该用户不存在");
        }
        User user = userMapper.getUserByAccount(account);
        if (!user.getPassword().equals(MD5Util.MD5(password + user.getSolt()))) {
            return CommonResult.success("账号或密码错误");
        }
        return CommonResult.success(user);
    }

    private boolean isUserExist(String account) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andAccountEqualTo(account);
        boolean isExist = userMapper.selectByExample(userExample).size() >= 1;
        if (isExist) {
            return true;
        } else {
            return false;
        }
    }


}
