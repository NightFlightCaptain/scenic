package com.smart.service;

import com.github.pagehelper.PageHelper;
import com.smart.dao.EssayMapper;
import com.smart.dao.UserEssayCollectionMapper;
import com.smart.dao.UserEssayGreatMapper;
import com.smart.domain.Essay;
import com.smart.domain.UserEssayCollection;
import com.smart.domain.UserEssayGreat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class EssayService {
    @Autowired
    private UserEssayGreatMapper userEssayGreatMapper;
    @Autowired
    private UserEssayCollectionMapper userEssayCollectionMapper;
    @Autowired
    private EssayMapper essayMapper;
    public Essay getEssayById(Long essayId){
        Essay essay=essayMapper.selectByPrimaryKey(essayId);
        if(essay!=null) {
            essay.setPageView(essay.getPageView() + 1);
            essayMapper.updateByPrimaryKey(essay);
        }
        return essay;
    }

    public List<Essay> getAllEssay(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Essay> essays=essayMapper.selectAll();
        return essays;
    }
    public String writeEssay(Essay essay){
        if(essay.getTitle()==null||essay.getauthorId()==null||essay.getAuthorName()==null)
            return "failure";
        if(essay.getTag()==null)
            essay.setTag("journey");
        if(essay.getclassify()==null)
            essay.setclassify("others");
        essay.setCreateTime(new Date());
        essayMapper.insert(essay);
        return "success";

    }
    public String modifyEssay(Essay essay){
        int i=essayMapper.updateByPrimaryKey(essay);
        if(i==1)
            return "success";
        else
            return "failure";
    }
    public String deleteEssay(long eaasayId){
        int i=essayMapper.deleteByPrimaryKey(eaasayId);
        if(i==1)
            return "success";
        else
            return "failure";
    }
    public List<Essay> getEssayByUserId(int pageNum,int pageSize,int userId){
        PageHelper.startPage(pageNum,pageSize);
        List<Essay> essays=essayMapper.selectByAuthor(userId);
        return essays;
    }
    public List<Essay> getEssayByTag(int pageNum,int pageSize,String tag){
        PageHelper.startPage(pageNum,pageSize);
        List<Essay> essays=essayMapper.selectByTag(tag);
        return essays;
    }public List<Essay> getEssayByClassify(int pageNum,int pageSize,String classify){
        PageHelper.startPage(pageNum,pageSize);
        List<Essay> essays=essayMapper.selectByClassify(classify);
        return essays;
    }

    public String collectEssay(UserEssayCollection userEssayCollection){
        int i=userEssayCollectionMapper.check(userEssayCollection);
        if(i==0){
            userEssayCollectionMapper.insert(userEssayCollection);
            return "已收藏";
        }
        else{
            userEssayCollectionMapper.delete(userEssayCollection);
            return "已取消";
        }

    }
    public String greatEssay(UserEssayGreat userEssayGreat){
        int i=userEssayGreatMapper.check(userEssayGreat);
        if(i==0){
            userEssayGreatMapper.insert(userEssayGreat);
            Essay essay=essayMapper.selectByPrimaryKey(userEssayGreat.getEssayId());
            essay.setGreatNum(essay.getGreatNum()+1);
            modifyEssay(essay);
            return "已点赞";
        }
        else{
            userEssayGreatMapper.delete(userEssayGreat);
            Essay essay=essayMapper.selectByPrimaryKey(userEssayGreat.getEssayId());
            essay.setGreatNum(essay.getGreatNum()-1);
            modifyEssay(essay);
            return "已取消";
        }

    }


    public List<Essay> getMyCollect(int pageNum,int pageSize,int userId){
        PageHelper.startPage(pageNum,pageSize);
        List<Essay> essays=essayMapper.selectMyCollect(userId);
        return essays;
    }


    public List<Essay> getMyGreat(int pageNum,int pageSize,int userId){
        PageHelper.startPage(pageNum,pageSize);
        List<Essay> essays=essayMapper.selectMyGreat(userId);
        return essays;
    }
    public  List<Essay> searchByKeyword(int pageNum,int pageSize,String keyword){
        PageHelper.startPage(pageNum,pageSize);
        List<Essay> essays=essayMapper.selectByKeyword(keyword);
        return essays;
    }
}
