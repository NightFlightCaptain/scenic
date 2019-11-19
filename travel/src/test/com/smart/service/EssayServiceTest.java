package com.smart.service;

import com.beust.jcommander.ParameterException;
import com.smart.domain.Essay;
import com.smart.domain.UserEssayCollection;
import com.smart.domain.UserEssayGreat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
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
public class EssayServiceTest {

    @Autowired
    private EssayService essayService;

    @Test
    public void getEssayById() {
        Essay essay = essayService.getEssayById(9L);
        Assert.assertNotNull(essay);
    }


    /**
     * id不存在，会报错
     */
    @Test
    public void getEssayByIdFail() {
        Essay essay = essayService.getEssayById(10000L);
        Assert.assertNull(essay);
    }

    /**
     * 获取全部的文章
     */
    @Test
    public void getAllEssay() {
        List<Essay> essays = essayService.getAllEssay(1, 10);
        for (Essay essay : essays) {
            Assert.assertNotNull(essay);
        }
    }

    /**
     * 添加一篇文章，应该会成功
     */
    @Test
    public void writeEssay() {
        Essay essay = new Essay();
        essay.setEssayId(10L);
        essay.setAuthorName("xiao li");
        essay.setTitle("昙华林");
        essay.setclassify("others");
        essay.setTag("journey");
        essay.setauthorId(1011);
        essay.setContent("昙华林是一个好地方");
        String result = essayService.writeEssay(essay);
        Assert.assertEquals("success", result);
    }


    /**
     * 添加一篇essayId已存在的文章，应该报错
     */
    @Test(expected = DuplicateKeyException.class)
    public void writeEssayFail() {
        Essay essay = new Essay();
        essay.setEssayId(9L);
        essay.setAuthorName("xiao li");
        essay.setTitle("昙华林");
        essay.setclassify("others");
        essay.setTag("journey");
        essay.setauthorId(1011);
        essay.setContent("昙华林是一个好地方");
        String result = essayService.writeEssay(essay);
    }

    /**
     * 没有title
     */
    @Test
    public void writeEssayFailWithTitleNull() {
        Essay essay = new Essay();
        essay.setEssayId(11L);
        essay.setAuthorName("xiao li");
        essay.setclassify("others");
        essay.setTag("journey");
        essay.setauthorId(1011);
        essay.setContent("昙华林是一个好地方");
        String result = essayService.writeEssay(essay);
        Assert.assertEquals("failure", result);
    }

    /**
     * 没有tag,会自动添加tag
     */
    @Test
    public void writeEssayFailWithTagNull() {
        Essay essay = new Essay();
        essay.setEssayId(15L);
        essay.setAuthorName("xiao li");
        essay.setTitle("昙华林");
        essay.setclassify("others");
        essay.setauthorId(1011);
        essay.setContent("昙华林是一个好地方");
        String result = essayService.writeEssay(essay);
        Assert.assertEquals("success", result);
    }

    /**
     * 没有Classify，会自动添加Classify
     */
    @Test
    public void writeEssayFailWithClassifyNull() {
        Essay essay = new Essay();
        essay.setEssayId(13L);
        essay.setAuthorName("xiao li");
        essay.setTitle("昙华林");
        essay.setTag("journey");
        essay.setauthorId(1011);
        essay.setContent("昙华林是一个好地方");
        String result = essayService.writeEssay(essay);
        Assert.assertEquals("success", result);
    }


    /**
     * 修改一篇文章，应该成功。但是这个地方报错了
     */
    @Test
    public void modifyEssay() {
        Essay essay = new Essay();
        essay.setEssayId(9L);
        essay.setauthorId(2);
        essay.setclassify("游记");
        String result = essayService.modifyEssay(essay);
        Assert.assertEquals("success",result);
    }

    /**
     * 修改文章，缺少必要的信息，理应报错
     */
    @Test()
    public void modifyEssayFail() {
        Essay essay = new Essay();
        essay.setauthorId(33333);
        String result = essayService.modifyEssay(essay);
        Assert.assertEquals("failure",result);
    }

    /**
     * 删除一篇文章，理应成功
     */
    @Test
    public void deleteEssay() {
        String result = essayService.deleteEssay(9L);
        Assert.assertEquals("success",result);
    }


    @Test
    public void deleteEssay2() {
        String result = essayService.deleteEssay(99999L);
        Assert.assertEquals("failure",result);
    }


    @Test
    public void getEssayByUserId() {
        List<Essay> essays = essayService.getEssayByUserId(2, 3, 1002);
        for (Essay essay : essays) {
            Assert.assertNotNull(essay);
        }
    }

    @Test
    public void getEssayByUserIdFail() {
        List<Essay> essays = essayService.getEssayByUserId(2, 3, 0032);
        Assert.assertEquals(0, essays.size());
    }


    @Test
    public void getEssayByTag() {
        List<Essay> essays = essayService.getEssayByTag(2, 3, "journey");
        Assert.assertNotNull(essays);
        for (Essay essay : essays) {
            Assert.assertNotNull(essay);
        }
    }

    @Test
    public void getEssayByTagFail() {
        List<Essay> essays = essayService.getEssayByTag(2, 3, "足球");
        Assert.assertEquals(0, essays.size());
    }


    @Test
    public void getEssayByClassify() {
        List<Essay> essays = essayService.getEssayByClassify(1,10,"others");
        Assert.assertNotNull(essays);
        for (Essay essay : essays) {
            Assert.assertNotNull(essay);
        }
    }

    /**
     * 收藏文章
     */
    @Test
    public void collectEssay() {
        UserEssayCollection collection = new UserEssayCollection();
        collection.setUserId(1);
        collection.setEssayId(9L);
        String result = essayService.collectEssay(collection);
        boolean res = "已收藏".equals(result) || "已取消".equals(result);
        Assert.assertTrue(res);
    }

    /**
     * 由于文章id不存在，所以应该报错或返回相关信息。
     */
    @Test
    public void collectEssayFail() {
        UserEssayCollection collection = new UserEssayCollection();
        collection.setUserId(1);
        collection.setEssayId(5L);
        String result = essayService.collectEssay(collection);
        Assert.assertEquals("failure",result);
    }

    @Test
    public void greatEssay() {
        UserEssayGreat great = new UserEssayGreat();
        great.setUserId(1);
        great.setEssayId(9L);
        String result = essayService.greatEssay(great);
        boolean res = "已点赞".equals(result) || "已取消".equals(result);
        Assert.assertTrue(res);
    }

    /**
     * 由于文章id不存在，所以应该报错或返回相关信息。
     */
    @Test
    public void greatEssayFail() {
        UserEssayGreat great = new UserEssayGreat();
        great.setUserId(1);
        great.setEssayId(5L);
        String result = essayService.greatEssay(great);
        Assert.assertEquals("failure",result);
    }

    @Test
    public void getMyCollect() {
        List<Essay> essays = essayService.getMyCollect(1, 2, 1);
        for (Essay essay : essays) {
            Assert.assertNotNull(essay);
        }
    }

    @Test
    public void getMyGreat() {
        List<Essay> essays = essayService.getMyGreat(1, 2, 1);
        for (Essay essay : essays) {
            Assert.assertNotNull(essay);
        }
    }

    @Test
    public void searchByKeyword() {
        List<Essay> essays = essayService.searchByKeyword(1,10,"好地方");
        for (Essay essay : essays) {
            Assert.assertNotNull(essay);
        }
    }
}