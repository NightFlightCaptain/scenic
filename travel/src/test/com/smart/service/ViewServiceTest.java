package com.smart.service;

import com.smart.domain.UserView;
import com.smart.domain.View;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * 该类上面加了Transactional注解，意味着该类下面所有的操作无论是否报错都将被回滚，也就是所有操作都不会对数据库产生影响
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:smart-context.xml", "classpath:smart-web.xml"})
@Transactional
public class ViewServiceTest {

    @Autowired
    private ViewService viewService;

    @Test
    public void getViewById() {
        View view = viewService.getViewById(1L);
        Assert.assertNotNull(view);
    }


    /**
     * 查找一个不存在的景点id
     */
    @Test
    public void getViewByIdNotExist() {
        View view = viewService.getViewById(99999L);
        Assert.assertNull(view);
    }

    @Test
    public void getAllView() {
        List<View> views = viewService.getAllView(1,10);
        Assert.assertNotNull(views);
        for (View view : views) {
            Assert.assertNotNull(view);
        }
    }

    @Test
    public void getMyFootprint() {
        List<View> views = viewService.getMyFootprint(1,10,1);
        Assert.assertNotNull(views);

    }

    @Test
    public void addView() {
        View insertView = new View();
        insertView.setViewId(2L);
        insertView.setViewName("黄鹤楼");
        insertView.setLocation("114.306344,30.542289");
        insertView.setIntroducation("黄鹤楼介绍");
        insertView.setclassify("名胜古迹");
        insertView.setOpentime("早上8：00-晚上5：00");
        viewService.addView(insertView);
    }


    /**
     * 重复的景点id，应该会报错
     */
    @Test(expected = DuplicateKeyException.class)
    public void addViewWithDuplicateKey() {
        View insertView = new View();
        insertView.setViewId(1L);
        insertView.setViewName("黄鹤楼");
        insertView.setLocation("114.306344,30.542289");
        insertView.setIntroducation("黄鹤楼介绍");
        insertView.setclassify("名胜古迹");
        insertView.setOpentime("早上8：00-晚上5：00");
        viewService.addView(insertView);
    }

    /**
     * 缺少必要信息，理应报错
     */
    @Test(expected = Exception.class)
    public void addViewWithoutNecessaryInfo() {
        View insertView = new View();
        insertView.setViewId(1L);
        insertView.setclassify("名胜古迹");
        insertView.setViewName("黄鹤楼");
        insertView.setIntroducation("黄鹤楼介绍");
        insertView.setOpentime("早上8：00-晚上5：00");
        viewService.addView(insertView);

    }

    @Test
    public void daka() {
        UserView userView = new UserView();
        userView.setUserId(1);
        userView.setViewId(1L);
        String result = viewService.daka(userView);
        Assert.assertEquals("已打卡",result);
    }

    /**
     * 不存在的景点id，理应报错
     */
    @Test(expected = Exception.class)
    public void dakaWithUnexistViewId() {
        UserView userView = new UserView();
        userView.setUserId(1);
        userView.setViewId(9999L);
        String result = viewService.daka(userView);
        Assert.assertEquals("已打卡",result);
    }

    /**
     * 不存在的用户id，理应报错
     */
    @Test(expected = Exception.class)
    public void dakaWithUnexistUserId() {
        UserView userView = new UserView();
        userView.setUserId(99999);
        userView.setViewId(1L);
        String result = viewService.daka(userView);
        Assert.assertEquals("已打卡",result);
    }

    /**
     * 不存在的景点id和不存在的用户id，理应报错
     */
    @Test(expected = Exception.class)
    public void dakaWithUnexistViewIdAndUserId() {
        UserView userView = new UserView();
        userView.setUserId(99999);
        userView.setViewId(9999L);
        String result = viewService.daka(userView);
        Assert.assertEquals("已打卡",result);
    }
}