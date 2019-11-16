package com.smart.service;

import com.smart.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;

import static org.junit.Assert.*;

/**
 *
 * 该类上面加了Transactional注解，意味着该类下面所有的操作无论是否报错都将被回滚，也就是所有操作都不会对数据库产生影响
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:smart-context.xml","classpath:smart-web.xml"})
@Transactional()
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void registerSuccess() {
        User user = new User();
        user.setUserId(2);
        user.setUserName("姜");
        user.setUserAccount("2");
        user.setPassword("123456");
        user.setHeadImgAddr("jianging");
        user.setGender("女");
        user.setSignature("1");

        String result = userService.register(user);
        Assert.assertEquals("success",result);
    }

    @Test
    public void registerWithNullParam() {
        User user = new User();
        user.setUserId(2);
        user.setUserName("姜");
        user.setPassword("123456");
        user.setHeadImgAddr("jianging");
        user.setGender("女");
        user.setSignature("1");

        String result = userService.register(user);
        Assert.assertEquals("failure",result);
    }

    /**
     * 添加一个userid重复的用户，理应报错
     */
    @Test(expected = DuplicateKeyException.class)
    public void registerFail() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("姜");
        user.setUserAccount("1");
        user.setPassword("123456");
        user.setHeadImgAddr("jianging");
        user.setGender("女");
        user.setSignature("1");

        String result = userService.register(user);
    }

    @Test
    public void loginSuccess() {
        User user = userService.login("1","123456");
        Assert.assertNotNull(user);
    }

    @Test
    public void loginFail() {
        User user = userService.login("10","123456");
        Assert.assertNull(user);
    }


    @Test
    public void changeInfo() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("周");
        user.setUserAccount("1");
        user.setWxCode("J");
        user.setPassword("123456");
        user.setHeadImgAddr("jianging");
        user.setGender("女");
        user.setSignature("1");
        String result = userService.changeInfo(user);
        Assert.assertEquals("success",result);
    }

    @Test
    public void changeInfoFail() {
        User user = new User();
        user.setUserId(12);
        user.setUserName("张");
        user.setUserAccount("12");
        user.setWxCode(null);
        user.setPassword("11323");
        user.setHeadImgAddr(null);
        user.setGender(null);
        user.setSignature(null);
        String result = userService.changeInfo(user);
        Assert.assertEquals("failure",result);
    }

    @Test
    public void bindWx() {
        String result = userService.bindWx("1","123456","test");
        Assert.assertEquals("success",result);
    }


    @Test
    public void bindWxWithUnexistAccount() {
        String result = userService.bindWx("222","123456","test");
        Assert.assertEquals("failure",result);
    }

    @Test
    public void loginByWx() {
        User user = userService.loginByWx("tt");
        Assert.assertNull(user);

    }
}