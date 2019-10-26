package com.hust.software.scenic.service.impl;

import com.hust.software.scenic.common.CommonResult;
import com.hust.software.scenic.mgb.mapper.MarkMapper;
import com.hust.software.scenic.mgb.model.Mark;
import com.hust.software.scenic.mgb.model.MarkExample;
import com.hust.software.scenic.service.MarkService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 小栗旬
 * @Date: 2019/10/26 12:37
 */
@Service
public class MarkServiceImpl implements MarkService{
    @Autowired
    private MarkMapper markMapper;

    @Override
    public CommonResult mark(Integer userId,Integer scenicId){
        if (isMarked(userId,scenicId)){
            return CommonResult.failed("该用户在该景点已经打卡过");
        }
        Mark mark = new Mark();
        mark.setUserId(userId);
        mark.setScenicId(scenicId);
        markMapper.insertSelective(mark);
        return CommonResult.success("打开成功，该用户是第"+userId+"位打卡的用户");
    }

    @Override
    public CommonResult outIsMarked(Integer userId,Integer scenicId){
        if (isMarked(userId,scenicId)){
            return CommonResult.success(true);
        }else {
            return CommonResult.success(false);
        }
    }
    /**
     * 该用户在该景点是否已经打卡过
     * @param userId
     * @param scenicId
     * @return
     */
    private boolean isMarked(Integer userId,Integer scenicId){
        MarkExample markExample = new MarkExample();
        MarkExample.Criteria criteria = markExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andScenicIdEqualTo(scenicId);
        criteria.andIsDeletedEqualTo(false);

        List<Mark> marks = markMapper.selectByExample(markExample);
        if (marks.size()==1){
            return true;
        }
        return false;
    }
}
