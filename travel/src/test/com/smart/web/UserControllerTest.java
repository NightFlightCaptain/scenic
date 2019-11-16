package com.smart.web;

import com.smart.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:smart-context.xml","classpath:smart-web.xml"})
public class UserControllerTest {

    @Autowired
    private UserController userController;
    @Test
    public void login() {
        User user = userController.login("!","1");
    }

    @Test
    public void loginByWx() {
    }

    @Test
    public void changeInfo() {
    }

    @Test
    public void register() {
    }

    @Test
    public void bindWx() {
    }

    @Test
    public void test1() {
    }
}