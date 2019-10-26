package com.hust.software.scenic.service;

import com.hust.software.scenic.common.CommonResult;

/**
 * @author: 小栗旬
 * @Date: 2019/10/26 13:03
 */
public interface CommentService {
    CommonResult addComment(Integer userId, Integer scenicId, String content, Integer score);

    CommonResult listComment(Integer scenicId);
}
