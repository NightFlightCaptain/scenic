package com.hust.software.scenic.component;

import com.hust.software.scenic.mgb.model.User;
import org.springframework.stereotype.Component;

/**
 * @author: 小栗旬
 * @Date: 2019/10/26 12:56
 */
@Component
public class HostHolder {
    private static ThreadLocal<User> users = new ThreadLocal<User>();

    public void setUser(User user){
        users.set(user);
    }

    public User getUser(){
        return users.get();
    }

    public void clear(){
        users.remove();
    }
}
