package com.hust.software.scenic.controller;

import com.hust.software.scenic.common.CommonResult;
import com.hust.software.scenic.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 小栗旬
 * @Date: 2019/10/26 13:10
 */
@RestController
@Api(tags = "CommentController",description = "评论接口")
public class CommentController implements InitializingBean {
    @Autowired
    private CommentService commentService;

    @ApiOperation("获取某景点下的全部评论")
    @GetMapping("comments")
    public CommonResult getComments(@RequestParam("scenicId") @ApiParam("景点id") Integer scenicId) {
        return commentService.listComment(scenicId);
    }

    @PostMapping("comment")
    @ApiOperation("增加一条评论")
    public CommonResult addComment(@RequestParam("userId") @ApiParam("用户id") Integer userId,
                                   @RequestParam("scenicId") @ApiParam("景点id") Integer scenicId,
                                   @RequestParam("content") @ApiParam("评论内容") String content,
                                   @RequestParam("score") @ApiParam("分数（1-5）") Integer score){
        return commentService.addComment(userId,scenicId,content,score);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
