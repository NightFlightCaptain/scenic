package com.hust.software.scenic.controller;

import com.hust.software.scenic.common.CommonResult;
import com.hust.software.scenic.service.MarkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 小栗旬
 * @Date: 2019/10/26 12:36
 */
@RestController
@Api(tags = "MarkController",description = "打卡接口")
public class MarkController {

    @Autowired
    private MarkService markService;

    @PostMapping("mark")
    @ApiOperation("打卡,打卡成功返回景点信息")
    public CommonResult addMark(@RequestParam("userId")@ApiParam("用户id") Integer userId,
                                @RequestParam("scenicId")@ApiParam("景点id") Integer scenicId){
        return markService.mark(userId,scenicId);
    }

    @GetMapping("isMarked")
    @ApiOperation("用户是否已在该处打卡过")
    public CommonResult isMarked(@RequestParam("userId")@ApiParam("用户id") Integer userId,
                                 @RequestParam("scenicId")@ApiParam("景点id") Integer scenicId){
        return markService.outIsMarked(userId,scenicId);
    }
}
