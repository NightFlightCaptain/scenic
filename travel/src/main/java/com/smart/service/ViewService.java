package com.smart.service;

import com.github.pagehelper.PageHelper;
import com.smart.dao.UserViewMapper;
import com.smart.dao.ViewMapper;
import com.smart.domain.UserView;
import com.smart.domain.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewService {
    @Autowired
    private UserViewMapper userViewMapper;
    @Autowired
    private ViewMapper viewMapper;

    public View getViewById(Long viewId){
        View view=viewMapper.selectByPrimaryKey(viewId);
        return view;
    }

    public List<View> getAllView(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<View> views=viewMapper.selectAll();
        return views;

    }

    public List<View> getMyFootprint(int pageNum,int pageSize,int userId){
        PageHelper.startPage(pageNum,pageSize);
        List<View> views=viewMapper.selectFootprint(userId);
        return views;

    }
    public String addView(View view){
        viewMapper.insert(view);
        return "success";
    }

    public String daka(UserView userView){
       int i= userViewMapper.check(userView);
       if(i==0)
           userViewMapper.insert(userView);
       return "已打卡";

    }



}
