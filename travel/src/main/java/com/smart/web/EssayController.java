package com.smart.web;

import com.smart.domain.*;
import com.smart.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/essay")
public class EssayController {
    @Autowired
    private EssayService essayService;
    @RequestMapping("/one")
    public Essay getEssayById(@RequestParam("essayId") long essayId){
        Essay essay=essayService.getEssayById(essayId);
        return essay;
    }
    @RequestMapping("/all")
    public List<Essay> getAllEssay(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        List<Essay> essays = essayService.getAllEssay(pageNum, pageSize);
        return essays;
    }
    @RequestMapping("/write")
    public Map<String, Object> writeEssay(Essay essay){
        String msg= essayService.writeEssay(essay);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg",msg);
        return map;
    }
    @RequestMapping("/modify")
    public Map<String, Object> modifyEssay(Essay essay){
        String msg= essayService.modifyEssay(essay);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg",msg);
        return map;
    }
    @RequestMapping("/delete")
    public Map<String, Object> deleteEssay(long essayId){
        String msg= essayService.deleteEssay(essayId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg",msg);
        return map;
    }
    @RequestMapping("/myEssay")
    public List<Essay> getMyEssay(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,@RequestParam("userId") int userId) {
        List<Essay> essays = essayService.getEssayByUserId(pageNum,pageSize,userId);
        return essays;
    }
    @RequestMapping("/classify")
    public List<Essay> getEssayByClassify(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,@RequestParam("classify") String classify) {
        List<Essay> essays = essayService.getEssayByClassify(pageNum,pageSize,classify);
        return essays;
    }
    @RequestMapping("/tag")
    public List<Essay> getEssayByTag(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,@RequestParam("tag") String tag) {
        List<Essay> essays = essayService.getEssayByTag(pageNum,pageSize,tag);
        return essays;
    }
    @RequestMapping("/collection")
    public Map<String, Object> collectEssay(UserEssayCollection userEssayCollection) {
        String msg = essayService.collectEssay(userEssayCollection);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", msg);
        return map;
    }
    @RequestMapping("/great")
    public Map<String, Object> greatEssay(UserEssayGreat userEssayGreat) {
        String msg = essayService.greatEssay(userEssayGreat);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", msg);
        return map;
    }
    @RequestMapping("/myCollect")
    public List<Essay> getMyCollect(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,@RequestParam("userId") int userId) {
        List<Essay> essays = essayService.getMyCollect(pageNum,pageSize,userId);
        return essays;
    }
    @RequestMapping("/myGreat")
    public List<Essay> getMyGreat(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,@RequestParam("userId") int userId) {
        List<Essay> essays = essayService.getMyGreat(pageNum,pageSize,userId);
        return essays;
    }
    @RequestMapping("/search")
    public List<Essay> searchByKeyword(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,@RequestParam("keyword") String keyword) {
        List<Essay> essays = essayService.searchByKeyword(pageNum,pageSize,keyword);
        return essays;
    }
}
