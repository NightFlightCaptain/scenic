package com.smart.web;

import com.github.pagehelper.PageHelper;
import com.smart.domain.UserView;
import com.smart.domain.View;
import com.smart.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/view")
public class ViewController {
    @Autowired
    private ViewService viewService;
    @RequestMapping("/one")
    public View getViewById( @RequestParam("viewId") long viewId){
        View view=viewService.getViewById(viewId);
        return view;
    }
    @RequestMapping("/all")
    public List<View> getAllView(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        List<View> views = viewService.getAllView(pageNum, pageSize);
        return views;
    }
    @RequestMapping("/myFootprint")
    public List<View> getMyFootprint(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,@RequestParam("userId") int userId) {
        List<View> views = viewService.getMyFootprint(pageNum,pageSize,userId);
        return views;
    }
    @RequestMapping("/daka")
    public Map<String, Object> daka(UserView userView) {
        String msg = viewService.daka(userView);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", msg);
        return map;
    }
    @RequestMapping("/addView")
    public Map<String, Object> addView(View view){
        String msg= viewService.addView(view);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg",msg);
        return map;
    }
}
