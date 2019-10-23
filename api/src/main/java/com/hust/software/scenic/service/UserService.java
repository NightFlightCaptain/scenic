package com.hust.software.scenic.service;

import com.hust.software.scenic.mgb.model.User;

/**
 * @author: 小栗旬
 * @Date: 2019/10/22 22:41
 */
public interface UserService {

    User addUser(User user);

    User getUser(String account, String password);
}
