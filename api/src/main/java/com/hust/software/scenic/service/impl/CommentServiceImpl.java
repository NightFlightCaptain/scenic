package com.hust.software.scenic.service.impl;

import com.hust.software.scenic.common.CommonResult;
import com.hust.software.scenic.mgb.mapper.CommentMapper;
import com.hust.software.scenic.mgb.model.Comment;
import com.hust.software.scenic.mgb.model.CommentExample;
import com.hust.software.scenic.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: 小栗旬
 * @Date: 2019/10/26 13:04
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public CommonResult addComment(Integer userId, Integer scenicId, String content, Integer score){
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setScenicId(scenicId);
        comment.setContent(content);
        comment.setScore(score);

        comment.setPublishTime(new Date());
        commentMapper.insertSelective(comment);
        return CommonResult.success("添加评论成功",comment);
    }

    @Override
    public CommonResult listComment(Integer scenicId){
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andScenicIdEqualTo(scenicId);
        criteria.andIsDeletedEqualTo(false);
        List<Comment> comments = commentMapper.selectByExampleWithBLOBs(commentExample);
        return CommonResult.success("获取该景点下全部评论",comments);
    }



}
